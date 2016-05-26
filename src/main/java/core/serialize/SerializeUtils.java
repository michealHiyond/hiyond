package core.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象序列化
 * 
 * @author Hiyond
 *
 */
public class SerializeUtils {

	/**
	 * 序列
	 * @param object
	 * @return
	 */
	public static byte[] serializeObj(Object object) {
		ObjectOutputStream objectOutputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			// 序列化
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			byte[] bytes = byteArrayOutputStream.toByteArray();
			return bytes;
		} catch (Exception e) {
			
		}finally {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
