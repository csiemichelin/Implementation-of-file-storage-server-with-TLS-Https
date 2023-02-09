# Implementation of file storage server with TLS Https
## 以TLS實現Https的安全性傳輸，並且可透過此檔案伺服器上完成上傳檔案和下載的動作
### 環境配置
1. Java 11
2. Maven 3.5.0
3. Eclipse, Intellij IDEA (or any other text editor like VIM)
4. A terminal
### 實驗步驟
**step1:** 到TLS_HttpsFileServer目錄下mvn install   
**step2:** 如果有更動source code的部份，到TLS_HttpsFileServer目錄下更新license -> mvn license:format。  
**step3:** 執行（VSCode的Run -> Start Debugging）TLS_HttpsFileServer/server/src/main/java/com/fish/server/App.java 則server啟動。      
**step4:** 去postman配置client的憑證和鑰匙，檔案在 TLS_HttpsFileServer/client。          
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/postman1.png?raw=true" width="400" height="300">   
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/postman2.png?raw=true" width="400" height="300">     
**step5:** 開啟postman去模擬client與server建立https連線（透過GET）。        
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/knock.png?raw=true" width="1000" height="300">    
**STEP6:** client向file server upload想要上傳的檔案，檔案會存到 TLS_HttpsFileServer/Files-Upload（透過POST）。    
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/upload.png?raw=true" width="1000" height="350">    
**STEP7:** client向file server download想要下載的檔案，檔案為上傳時產生的 downloadUri "/downloadFile/{fileCode}"的文件代碼，檔案會存到 TLS_HttpsFileServer/Files-Download（透過GET）。       
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/download.png?raw=true" width="1000" height="500">    
