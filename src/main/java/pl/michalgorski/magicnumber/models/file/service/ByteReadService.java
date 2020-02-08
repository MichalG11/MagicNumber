package pl.michalgorski.magicnumber.models.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class ByteReadService {

    /**
     * The method reads a file and returns a byte array.
     *
     * @param file
     * @return
     * @throws IOException
     */
    byte[] getBytesOfFile(final File file) throws IOException {

        final byte[] lines = Files.readAllBytes(file.toPath());

        return lines;
    }
}
