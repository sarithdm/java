1. Compile Remote Interface Adder.java

javac Adder.java

2. Compile Implementation of Remote Interface AdderRemote.java

javac AdderRemote.java

3. Create Stub and Skelton using RMIC tool (You will be getting warning)

Warning: generation and use of skeletons and static stubs for JRMP
is deprecated. Skeletons are unnecessary, and static stubs have
been superseded by dynamically generated stubs. Users are
encouraged to migrate away from using rmic to generate skeletons and static
stubs. See the documentation for java.rmi.server.UnicastRemoteObject.

rmic AdderRemote

4. Start RMI registry. Keep it running.

rmiregistry 5000  

5. Take another terminal/powershell/CMD and compile MyServer.java

javac MyServer.java

6. Run Server. Keep it running.

java MyServer

7. Take another terminal/powershell/CMD and compile MyServer.java

javac MyClient.java

8. Run Client

java MyClient


You will get output for adding two numbers. Make changes to the code and try yourself.
