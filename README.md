## Impementing TCP/IP protocol in java

> This project is to immitate the functionalities of data-link layer and physical layer on our system using a single server - multiple client system. The code is written in Java.

### Prerequisites -
 
 -  Java version `1.8`
 -  Suitable IDE

### How to run the code - 

- Open the `MultithreadedSocketServer.java` and run it to start the server.
- Connect the clients with the server by running the `ServerClientThread.java`
- Send message from client side along with the character `y` or `n` depending on whether to generate error or not.
- At the server side, enter the reply to be sent to the client.
- To disconnect the client from the server, enter `bye` as the message.

### Underlying Implementation -

- At the client side, the data-link header is first added, and then the data is divided into packets and on each packet, CRC remainder is added.
- Finally the data is encoded using __Manchester Encoding__ scheme where low voltage is represented by -1 and high voltage by 1.This encoded message will finally be sent to the server.
- At the Server side, the server will receive the encoded message, it will decode it, and then check for the error using __CRC scheme__.
- If there is error in the message, the server will request again for the message from the client.
- If the message is error-free, the server will display the packets received, it will remove the data-link header and then rejoin all the packets to generate the original message and display that message on the screen.
- The reply will then be sent to the client.
