/**
 * 
 */
package common;

import java.lang.reflect.Type;

import org.hibernate.proxy.HibernateProxy;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Chen
 *
 */
public class HibernateProxySerializer implements JsonSerializer<HibernateProxy> {

	@Override
	public JsonElement serialize(HibernateProxy hibernateProxy, Type type,
			JsonSerializationContext context) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		//blow ensures deep deproxied serialization.
		gsonBuilder.registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxySerializer());
		Object deProxied = hibernateProxy.getHibernateLazyInitializer().getImplementation();
		
		return gsonBuilder.create().toJsonTree(deProxied);
	}
	
}
