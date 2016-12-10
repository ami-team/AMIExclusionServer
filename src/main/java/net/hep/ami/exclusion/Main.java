package net.hep.ami.exclusion;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import java.util.regex.*;
import java.util.logging.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;

public class Main extends AbstractHandler
{
	/*---------------------------------------------------------------------*/

	private final Map<String, String> m_locks = new HashMap<>();

	/*---------------------------------------------------------------------*/

	private final Pattern m_regexp = Pattern.compile(
		"\\s*,\\s*"
	);

	/*---------------------------------------------------------------------*/

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String data;

		/*-----------------------------------------------------------------*/
		/* EXECUTE COMMAND                                                 */
		/*-----------------------------------------------------------------*/

		String command = req.getParameter("Command");

		if(command != null)
		{
			/*-------------------------------------------------------------*/
			/* PARSE COMMAND                                               */
			/*-------------------------------------------------------------*/

			List<String> args = new ArrayList<String>();

			for(String arg: m_regexp.split(command))
			{
				args.add(arg.trim());
			}

			/*-------------------------------------------------------------*/
			/* EXECUTE COMMAND                                             */
			/*-------------------------------------------------------------*/

			if(args.isEmpty() == false)
			{
				int nr = args.size() - 1;

				String cmd = args.remove(0);

				/**/ if(nr >= 2 && cmd.equals("Lock")) {
					data = lock(args.remove(0), args);
				}
				else if(nr >= 2 && cmd.equals("Unlock")) {
					data = unlock(args.remove(0), args);
				}
				else if(nr == 1 && cmd.equals("UnlockAll")) {
					data = unlockAll(args.remove(0), args);
				}
				else {
					data = "-1";
				}
			}
			else {
				data = "-1";
			}
		}
		else {
			data = "-1";
		}

		/*-----------------------------------------------------------------*/
		/* CLOSE WRITER                                                    */
		/*-----------------------------------------------------------------*/

		try
		{
			PrintWriter writer = res.getWriter();

			writer.print(data);

			writer.close();
		}
		finally
		{
			baseRequest.setHandled(true);
		}

		/*-----------------------------------------------------------------*/
		/* OKAY                                                            */
		/*-----------------------------------------------------------------*/

		res.setContentType("text/plain");

		res.setStatus(HttpServletResponse.SC_OK);

		/*-----------------------------------------------------------------*/
	}

	/*---------------------------------------------------------------------*/

	private String lock(String server, List<String> args)
	{
		synchronized(this)
		{
			/**/	/*-----------------------------------------------------*/
			/**/
			/**/	for(String arg: args) if(m_locks.get(arg) != null) return "1";
			/**/
			/**/	/*-----------------------------------------------------*/
			/**/
			/**/	for(String arg: args) m_locks.put(arg, server);
			/**/
			/**/	/*-----------------------------------------------------*/
		}

		return "0";
	}

	/*---------------------------------------------------------------------*/

	private String unlock(String server, List<String> args)
	{
		String SERVER;

		synchronized(this)
		{
		/**/	for(String arg: args)
		/**/	{
		/**/		SERVER = m_locks.get(arg);
		/**/
		/**/		if(SERVER != null && SERVER.equals(server)) m_locks.remove(arg);
		/**/	}
		}

		return "0";
	}

	/*---------------------------------------------------------------------*/

	private synchronized String unlockAll(String server, List<String> args)
	{
		List<String> tmp = new ArrayList<>();

		synchronized(this)
		{
		/**/	/*---------------------------------------------------------*/
		/**/
		/**/	for(Entry<String, String> entry: m_locks.entrySet()) if(entry.getValue().equals(server)) tmp.add(entry.getKey());
		/**/
		/**/	/*---------------------------------------------------------*/
		/**/
		/**/	for(String lock: tmp) m_locks.remove(lock);
		/**/
		/**/	/*---------------------------------------------------------*/
		}

		return "0";
	}

	/*---------------------------------------------------------------------*/

	public static void main(String[] args)
	{
		try
		{
			Server server = new Server(args.length == 1 ? Integer.parseInt(args[0]) : 1358);

			server.setStopAtShutdown(true);

			server.setHandler(new Main());

			server.start();
			server.join();
		}
		catch(Exception e)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE,
				e.getMessage(), e
			);

			System.exit(1);
		}

		System.exit(0);
	}

	/*---------------------------------------------------------------------*/
}
