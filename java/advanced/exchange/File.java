package kyd;

import java.io.IOException;

public class File {
	FileOutput fw;

	public void fileWriter(Variable val) throws IOException{
		fw = new FileOutput();
		fw.headerWrite();
		fw.dataWrite(val);
		fw.fileClose();
	}

}
