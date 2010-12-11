package net.juckel.osgijrubytest;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.SimpleScriptContext;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.jruby.Ruby;
import org.jruby.embed.jsr223.JRubyEngine;
import org.jruby.embed.jsr223.JRubyEngineFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class Application implements IApplication {

//	@Override
	public Object start(IApplicationContext context) throws Exception {
		JRubyEngineFactory fact = new JRubyEngineFactory();
//		fact.setClassLoader(this.getClass().getClassLoader());
		JRubyEngine engine = (JRubyEngine)fact.getScriptEngine();
		// engine.getContext().setWriter(new OutputStreamWriter(System.out));
		//engine.getBindings(ScriptContext.ENGINE_SCOPE).put("foo", this.getClass().getClassLoader());
		Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE); 
		bindings.put("foo", this.getClass().getClassLoader());
		bindings.put("out", System.out);
		try {
			InputStream stream = this.getClass().getResourceAsStream("/src/main/ruby/simple.rb");
			// URL jirb = b.getEntry("/META-INF/jruby.home/bin/jirb_swing");
	//		engine.eval(new InputStreamReader(jirb.openStream()));
			Object returnValue =  engine.eval(new InputStreamReader(stream), bindings);
	//		System.out.printf("Value: %s; %s", returnValue.getClass().getName(), returnValue.toString());
			return Integer.valueOf(0);
		} catch ( Exception e ) {
			e.printStackTrace();
			throw e;
		}
	}

//	@Override
	public void stop() {
	}
}
