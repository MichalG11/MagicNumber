package pl.michalgorski.magicnumber.models.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class ByteReadService {

    byte[] getBytesOfFile(final File file) throws IOException {

        final byte[] lines = Files.readAllBytes(file.toPath());

        return lines;
    }
}
