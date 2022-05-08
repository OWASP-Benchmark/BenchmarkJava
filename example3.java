Intent in = getIntent();
String path = in.getStringExtra("path");
if(path == null)
return;
String sdcard =  Environment.getExternalStorageDirectory()
if(path.startsWith(sdcard))
{
	Log.e(TAG, "Attempt to write to sdcard");
	return;
}
writeToFile(path);
