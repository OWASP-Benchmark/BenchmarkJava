import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
⋮
public void extract(ZipFile zip) {
     ⋮
     String toDir = "/my/target/directory/";
     Enumeration entries = zip.entries();
     while (entries.hasMoreElements()) {
        ZipEntry zipEntry = entries.nextElement();
        ⋮
        File file = new File(toDir, zipEntry.getName())
        if( !file.getCanonicalPath().startsWith(toDir) ){
          throw new SecurityException("ZipEntry not within target directory!");
        }
        InputStream istr = zipFile.getInputStream(zipEntry);
        final OutputStream os = Files.newOutputStream(file.toPath());
        bos  = new BufferedOutputStream(os);
        IOUtils.copy(bis, bos);
    }
}
