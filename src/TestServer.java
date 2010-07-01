import org.teleal.cling.binding.annotations.*;
import org.teleal.common.util.ByteArray;
import java.util.Random;
import java.util.zip.CRC32;

//TODO: add options that can be set on the server by the client to demo
//      transfers in both directions

@UpnpService(
  serviceId = @UpnpServiceId(value = "UPnPTestServer-JavaCling",
                             namespace = "pipeep"),
  serviceType = @UpnpServiceType(value = "UPnPTestServer",
                                 namespace = "schemas-pipeep",
                                 version = 1)
)
public class TestServer {
  
  @UpnpStateVariable(name = "RandomData", sendEvents = false)
  private Byte[] data;
  
  @UpnpStateVariable(name = "DataChecksum", sendEvents = false)
  private Integer checksum;
  
  public TestServer() {
    byte[] rawData = new byte[1024*1024]; //one MB of data
    new Random().nextBytes(rawData);
    data = ByteArray.toWrapper(rawData);
    checksum = calculateChecksum(rawData); //Autoboxing!
  }
  
  
  @UpnpAction(out = @UpnpOutputArgument(name = "DataChecksum"))
  public Integer getChecksum() {
    return checksum;
  }
  
  @UpnpAction(out = @UpnpOutputArgument(name = "RandomData"))
  public Byte[] getData() {
    return data;
  }
  
  public static int calculateChecksum(Byte[] data) {
    return calculateChecksum(ByteArray.toPrimitive(data));
  }
  
  public static int calculateChecksum(byte[] data) {
    CRC32 crc = new CRC32();
    crc.update(data);
    return (int)crc.getValue();
  }
}
