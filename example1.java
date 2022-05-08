def path = System.console().readLine 'Enter file path:'
if (path.startsWith("/safe_dir/"))
{
	File f = new File(path);
	f.delete()
}
