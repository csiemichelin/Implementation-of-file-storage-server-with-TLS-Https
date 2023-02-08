/*
 * Copyright 2018 Thunderberry.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fish.server.controller;
 
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
 
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
 
public class FileDownloadUtil {
    private Path foundFile;
    
 
    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get("Files-Upload");
         
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });
 
        if (foundFile != null) {
            FileOutputStream fileOut = null;  
            String path_to_string = foundFile.toString();
            System.out.printf("Upload File path: %s\nUpload File Uri: %s\n", path_to_string , foundFile.toUri());
            URI fileURI = foundFile.toUri();
            String uriString = fileURI.toString();
            String fileName = path_to_string .replace("Files-Upload/", "");
            String saveDir = "/home/itri460857/Documents/TLS_HttpsFileServer/Files-Download/";
            URL url = new URL(uriString);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(saveDir + fileName);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();

            return new UrlResource(foundFile.toUri());
        }
         
        return null;
    }
}
