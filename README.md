# Implementation of file storage server with TLS Https
## 以TLS實現Https的安全性傳輸，並且可透過此檔案伺服器上完成上傳檔案和下載的動作
### 環境配置
1. Java 11
2. Maven 3.5.0
3. Eclipse, Intellij IDEA (or any other text editor like VIM)
4. A terminal
### 名詞解釋
1. 私鑰 (Private Key)：是一種密碼學中的金鑰，用於加密和解密數據。私鑰是由密碼學算法生成的一個長度較長的隨機數字串，只有擁有私鑰的人才能夠對使用相應的公鑰加密的信息進行解密。私鑰用於加密和簽署數據。
2. 憑證 (Certificate)：是一個由可信任的第三方機構（例如憑證授權機構）簽發的數字證書，用於證明某個實體的身份。憑證通常包含有關持有者身份的信息，以及憑證的有效期、公鑰等數據。憑證用於加密和驗證數據。
3. Keystore：存儲自己的憑證和私鑰，用於識別和驗證自己的身份。舉例來說，假設你是一個 Web 伺服器擁有者，你需要在你的伺服器上安裝一個 SSL/TLS 憑證以啟用 HTTPS 通信。當你從一個 CA 申請並獲得了這個憑證時，你需要將憑證和相應的私鑰存儲在你的 Keystore 中。這樣，當你的伺服器收到客戶端的連接請求時，它可以使用該憑證和私鑰來建立 SSL/TLS 連接並保護傳輸的數據。在這種情況下，Keystore 中的憑證是用於識別和驗證 Web 伺服器擁有者的身份。
4. Truststore：存儲由可信的第三方機構簽發的憑證（像是openssl免費提供），用於驗證其他應用程序或系統的身份。例如，假設你需要從另一個應用程序中訪問一個 Web 服務器，你需要使用該應用程序建立一個 SSL/TLS 連接。在這種情況下，該應用程序會使用存儲在其 Truststore 中的憑證來驗證該 Web 服務器的身份，確保它是真實存在並且是由一個可信的第三方機構簽發的憑證。如果該憑證有效且被信任，那麼該應用程序可以建立 SSL/TLS 連接，並與該 Web 服務器進行安全通信。在這種情況下，Truststore 中的憑證是用於驗證其他應用程序或系統的身份，以確保通信的安全性和可靠性。
### OpenSSL建立私鑰和憑證   
<https://blog.ladsai.com/ubuntu-%E4%BD%BF%E7%94%A8-openssl-%E7%94%A2%E7%94%9F%E6%86%91%E8%AD%89.html/>   
<https://gist.github.com/Hakky54/b30418b25215ad7d18f978bc0b448d81/>
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
