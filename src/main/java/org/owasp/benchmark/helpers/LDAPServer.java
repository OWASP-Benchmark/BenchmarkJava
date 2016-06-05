package org.owasp.benchmark.helpers;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import org.apache.directory.server.constants.ServerDNConstants;
import org.apache.directory.server.core.DefaultDirectoryService;
import org.apache.directory.server.core.DirectoryService;
import org.apache.directory.server.core.partition.Partition;
import org.apache.directory.server.core.partition.impl.btree.jdbm.JdbmIndex;
import org.apache.directory.server.core.partition.impl.btree.jdbm.JdbmPartition;
import org.apache.directory.server.core.partition.ldif.LdifPartition;
import org.apache.directory.server.core.schema.SchemaPartition;
import org.apache.directory.server.ldap.LdapServer;
import org.apache.directory.server.protocol.shared.transport.TcpTransport;
import org.apache.directory.server.xdbm.Index;
import org.apache.directory.shared.ldap.entry.Entry;
import org.apache.directory.shared.ldap.entry.ServerEntry;
import org.apache.directory.shared.ldap.name.DN;
import org.apache.directory.shared.ldap.schema.SchemaManager;
import org.apache.directory.shared.ldap.schema.ldif.extractor.SchemaLdifExtractor;
import org.apache.directory.shared.ldap.schema.ldif.extractor.impl.DefaultSchemaLdifExtractor;
import org.apache.directory.shared.ldap.schema.loader.ldif.LdifSchemaLoader;
import org.apache.directory.shared.ldap.schema.manager.impl.DefaultSchemaManager;
import org.apache.directory.shared.ldap.schema.registries.SchemaLoader;

public class LDAPServer {
	/** The directory service */
	private DirectoryService service;

	/** The LDAP server */
	private LdapServer server;

	public LDAPServer() {
		String dir = Utils.getFileFromClasspath("benchmark.properties", LDAPManager.class.getClassLoader()).getParent();
		File workDir = new File(dir + "/../ldap");
		workDir.mkdirs();

		// Create the server
		try {
			initDirectoryService(workDir);
		} catch (Exception e) {
			System.out.println("Error creating LDAP Server: " + e.getMessage());
		}

		// Read an entry
		Entry result = null;
		try {
			result = service.getAdminSession().lookup(new DN("dc=apache,dc=org"));
		} catch (Exception e) {
			System.out.println("Error creating LDAP Server: " + e.getMessage());
		}

		// And print it if available
//		System.out.println("Found entry : " + result);

		// optionally we can start a server too
		try {
			startServer();
		} catch (Exception e) {
			System.out.println("Error creating LDAP Server: " + e.getMessage());
		}
		
		LDAPManager emd = new LDAPManager();
		LDAPPerson ldapP = new LDAPPerson();
		ldapP.setName("foo");
		ldapP.setPassword("MrFooPa$$word");
		ldapP.setAddress("AddressForFoo #345");

		emd.insert(ldapP);

		ldapP = new LDAPPerson();
		ldapP.setName("Ms Bar");
		ldapP.setPassword("barM$B4dPass");
		ldapP.setAddress("The streetz 4 Ms bar");

		emd.insert(ldapP);

		ldapP = new LDAPPerson();
		ldapP.setName("Mr Unknown");
		ldapP.setPassword("YouwontGue$$");
		ldapP.setAddress("Whe home is #678");

		emd.insert(ldapP);
	}

	/**
	 * Initialize the server. It creates the partition, adds the index, and
	 * injects the context entries for the created partitions.
	 *
	 * @param workDir
	 *            the directory to be used for storing the data
	 * @throws Exception
	 *             if there were some problems while initializing the system
	 */
	private void initDirectoryService(File workDir){
		// Initialize the LDAP service
		try {
			service = new DefaultDirectoryService();
		} catch (Exception e1) {
			System.out.println("Error creating DefaultDirectoryService. " + e1.getMessage());
		}
		service.setWorkingDirectory(workDir);

		// first load the schema
		initSchemaPartition();

		// then the system partition
		// this is a MANDATORY partition
		Partition systemPartition = null;
		try {
			systemPartition = addPartition("system", ServerDNConstants.SYSTEM_DN);
		} catch (Exception e1) {
			System.out.println("Error addPartition system. " + e1.getMessage());
		}
		service.setSystemPartition(systemPartition);

		// Disable the ChangeLog system
		service.getChangeLog().setEnabled(false);
		service.setDenormalizeOpAttrsEnabled(true);

		// Now we can create as many partitions as we need
		// Create some new partitions named 'foo', 'bar' and 'apache'.
		Partition fooPartition = null;
		try {
			fooPartition = addPartition("foo", "dc=foo,dc=com");
		} catch (Exception e1) {
			System.out.println("Error addPartition foo. " + e1.getMessage());
		}
		Partition barPartition = null;
		try {
			barPartition = addPartition("bar", "dc=bar,dc=com");
		} catch (Exception e1) {
			System.out.println("Error addPartition bar. " + e1.getMessage());
		}
		Partition apachePartition = null;
		try {
			apachePartition = addPartition("apache", "dc=apache,dc=org");
		} catch (Exception e1) {
			System.out.println("Error addPartition apache. " + e1.getMessage());
		}

		// Index some attributes on the apache partition
		addIndex(apachePartition, "objectClass", "ou", "uid");
		try {
			// And start the service
			service.startup();
		} catch (Exception e) {
			System.out.println("Error at LDAP startup: " + e.getMessage());
		}
		// Inject the foo root entry if it does not already exist
		try {
			service.getAdminSession().lookup(fooPartition.getSuffixDn());
		} catch (Exception lnnfe) {
			try {
				DN dnFoo = new DN("dc=foo,dc=com");
				ServerEntry entryFoo = service.newEntry(dnFoo);
				entryFoo.add("objectClass", "top", "domain", "extensibleObject");
				entryFoo.add("dc", "foo");
				service.getAdminSession().add(entryFoo);
			} catch (Exception e) {
				System.out.println("Error creating new DN.");
			}
		}

		// Inject the bar root entry
		try {
			service.getAdminSession().lookup(barPartition.getSuffixDn());
		} catch (Exception lnnfe) {
			try {
				DN dnBar = new DN("dc=bar,dc=com");
				ServerEntry entryBar = service.newEntry(dnBar);
				entryBar.add("objectClass", "top", "domain", "extensibleObject");
				entryBar.add("dc", "bar");
				service.getAdminSession().add(entryBar);
			} catch (Exception e) {
				System.out.println("Error creating new DN.");
			}
		}

		// Inject the apache root entry
		try {
			if (!service.getAdminSession().exists(apachePartition.getSuffixDn())) {
				try{
					DN dnApache = new DN("dc=Apache,dc=Org");
					ServerEntry entryApache = service.newEntry(dnApache);
					entryApache.add("objectClass", "top", "domain", "extensibleObject");
					entryApache.add("dc", "Apache");
					service.getAdminSession().add(entryApache);
				} catch (Exception e) {
					System.out.println("Error creating new DN.");
				}
			}
		} catch (Exception e) {
			System.out.println("Error when checking if partition exists.");
		}

	}

	/**
	 * initialize the schema manager and add the schema partition to diectory
	 * service
	 *
	 * @throws Exception
	 *             if the schema LDIF files are not found on the classpath
	 */
	private void initSchemaPartition() {
		SchemaPartition schemaPartition = service.getSchemaService().getSchemaPartition();

		// Init the LdifPartition
		LdifPartition ldifPartition = new LdifPartition();
		String workingDirectory = service.getWorkingDirectory().getPath();
		ldifPartition.setWorkingDirectory(workingDirectory + "/schema");

		// Extract the schema on disk (a brand new one) and load the registries
		File schemaRepository = new File(workingDirectory, "schema");
		File wd = new File(workingDirectory);
		SchemaLdifExtractor extractor = new DefaultSchemaLdifExtractor(wd);
		try {
			extractor.extractOrCopy( true );
			//System.out.println("is Extracted: " + extractor.isExtracted());
		} catch (Exception e) {
		}
		
		schemaPartition.setWrappedPartition(ldifPartition);
		try {
			SchemaLoader loader = new LdifSchemaLoader(schemaRepository);
			SchemaManager schemaManager = new DefaultSchemaManager(loader);
			service.setSchemaManager(schemaManager);

			// We have to load the schema now, otherwise we won't be able
			// to initialize the Partitions, as we won't be able to parse
			// and normalize their suffix DN
			schemaManager.loadAllEnabled();

			schemaPartition.setSchemaManager(schemaManager);

			List<Throwable> errors = schemaManager.getErrors();

			if (errors.size() != 0) {
				throw new Exception("Schema load failed : " + errors);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Add a new partition to the server
	 *
	 * @param partitionId
	 *            The partition Id
	 * @param partitionDn
	 *            The partition DN
	 * @return The newly added partition
	 * @throws Exception
	 *             If the partition can't be added
	 */
	private Partition addPartition(String partitionId, String partitionDn) throws Exception {
		// Create a new partition named 'foo'.
		JdbmPartition partition = new JdbmPartition();
		partition.setId(partitionId);
		partition.setPartitionDir(new File(service.getWorkingDirectory(), partitionId));
		partition.setSuffix(partitionDn);
		service.addPartition(partition);

		return partition;
	}

	/**
	 * Add a new set of index on the given attributes
	 *
	 * @param partition
	 *            The partition on which we want to add index
	 * @param attrs
	 *            The list of attributes to index
	 */
	private void addIndex(Partition partition, String... attrs) {
		// Index some attributes on the apache partition
		HashSet<Index<?, ServerEntry, Long>> indexedAttributes = new HashSet<Index<?, ServerEntry, Long>>();

		for (String attribute : attrs) {
			indexedAttributes.add(new JdbmIndex<String, ServerEntry>(attribute));
		}

		((JdbmPartition) partition).setIndexedAttributes(indexedAttributes);
	}

	/**
	 * starts the LdapServer
	 *
	 * @throws Exception
	 */
	public void startServer() throws Exception {
		server = new LdapServer();
		int serverPort = 10389;
		server.setTransports(new TcpTransport(serverPort));
		server.setDirectoryService(service);

		server.start();
	}

	public void stopServer() throws Exception {
		if (server != null) {
			server.stop();
			if (server.getDirectoryService() != null) {
				server.getDirectoryService().shutdown();
			}
		}
	}
	
	/**
	 * Main class.
	 *
	 * @param args
	 *            Not used.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		LDAPServer ldap = new LDAPServer();
		//ldap.stopServer();
	}

}
