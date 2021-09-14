# Installation guide of HouseHolds application

### Installing client application

To install the application, you need to allow installing apk-s from unknown sources. Here's how to do it:

1. Navigate to Setting > Security.
2. Check the option “Unknown sources“.
3. Tap OK on the prompt message.
4. Select “Trust“.

After this is done, transfer the apk to the phone, open it and install. After it is installed, you can open and use it.


### Deploying server to different environment

The release package contains the .jar file of the server. The jar file has all the needed dependencies included in it, server is running on port 8080. To deploy, follow the instructions of your specific deployment environment, in general, you need to upload this jar to the environment and configure a load balancer to communicate with the server on port 8080.

If you decide to deploy the server to your own environment, you will need to rebuild the client with new base url of the server api. To do so, go to file cz.cvut.fit.sp1.households.client.utils, and change the BASE_URL field to the new base url, then rebuild the apk.
