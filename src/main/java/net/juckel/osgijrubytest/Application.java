package net.juckel.osgijrubytest;

import java.io.InputStream;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.jruby.embed.ScriptingContainer;

public class Application implements IApplication {

//	@Override
	public Object start(IApplicationContext context) throws Exception {
		InputStream stream = this.getClass().getResourceAsStream("/src/main/ruby/simple.rb");
		ScriptingContainer container = new ScriptingContainer();
		container.setClassLoader(this.getClass().getClassLoader());
		container.runScriptlet(stream, "simple.rb");
		return Integer.valueOf(0);
	}

//	@Override
	public void stop() {
	}
}
