# Implementation of file storage server with TLS Https
## 以TLS實現Https的安全性傳輸，並且可透過此檔案伺服器上完成上傳檔案和下載的動作
**step1:** 如果有更動source code的部份，到TLS_HttpsFileServer目錄下更新license -> mvn license:format。  
**step2:** 執行（VSCode的Run -> Start Debugging）TLS_HttpsFileServer/server/src/main/java/com/fish/server/App.java 則server啟動。      
**step3:** 去postman配置client的憑證和鑰匙，檔案在 TLS_HttpsFileServer/client。          
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/postman1.png?raw=true" width="400" height="300"><img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/postman2.png?raw=true" width="400" height="300">     
**step4:** 開啟postman去模擬client與server建立https連線（透過GET）。        
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/knock.png?raw=true" width="1000" height="300">    
**STEP5:** client向file server upload想要上傳的檔案。    
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/upload.png?raw=true" width="1000" height="300">    
**STEP6:** client向file server download想要下載的檔案，檔案為上傳時產生的 downloadUri "/downloadFile/{fileCode}"的文件代碼。       
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/download.png?raw=true" width="1000" height="300">    
