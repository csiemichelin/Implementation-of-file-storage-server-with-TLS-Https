# Implementation of file storage server with TLS Https
## 以TLS實現Https的安全性傳輸，並且可透過此檔案伺服器上完成上傳檔案和下載的動作
**step1:** 如果有更動source code的部份，到TLS_HttpsFileServer目錄下更新license -> mvn license:format。  
**step2:** 執行（VSCode的Run -> Start Debugging）TLS_HttpsFileServer/server/src/main/java/com/fish/server/App.java 則server啟動。   
**step3:** 開啟postman去模擬client與server建立https連線   
&emsp;&emsp;&emsp;<img src="https://github.com/csiemichelin/Implementation-of-file-storage-server-with-TLS-Https/blob/main/TLS_HttpsFileServer/images/knock.png?raw=true" width="200" height="200">  

