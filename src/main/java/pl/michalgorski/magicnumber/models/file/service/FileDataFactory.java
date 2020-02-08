package pl.michalgorski.magicnumber.models.file.service;

import pl.michalgorski.magicnumber.models.file.data.FileData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataFactory {

    private ByteReadService byteReadService;

    public FileDataFactory(){
        byteReadService = new ByteReadService();
    }
    public List<FileData> createFileDataList(List<File> list) throws IOException {

        List<FileData> listOfFileData = new ArrayList<>();

        for (File oneFile : list) {
            FileData fileData = createFileData(oneFile);
            listOfFileData.add(fileData);
        }

        return listOfFileData;
    }

    private FileData createFileData(File file) throws IOException {

        String fileName = file.getName();

        byte[] realByteArray = byteReadService.getBytesOfFile(file);

        return null;
    }
}
