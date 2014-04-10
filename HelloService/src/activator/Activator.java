package activator;

import helloservice.HelloServiceImpl;
import ihelloservice.HelloService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration registration;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
//		registration = bundleContext.registerService(HelloService.class.getName(), new HelloServiceImpl(), null);
		registration = bundleContext.registerService(HelloService.class, new HelloServiceImpl(), null);
		// Interface Test
		HelloService h = new HelloServiceImpl();
		if(h instanceof HelloService) {
			System.out.println("HelloServiceImpl is an instance of HelloService");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		registration.unregister();
	}

}
