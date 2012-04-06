import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SOSInterface extends Applet {
	
	String pathToSos = "/home/iliyan/52north/52n-sos/52n-sos-service/src/main/webapp/WEB-INF/conf/sos.config";
	String pathToDssos = "/home/iliyan/52north/52n-sos/conf/dssos.config";
	Button launchSos = new Button("Dysplay the contents of sos.config");
	Button launchDssos = new Button("Dysplay the contents of dssos.config");
	TextArea conf;

	public void init() {
		add(launchSos);
		add(launchDssos);
		launchSos.addActionListener(new LaunchSOSListener());
		launchDssos.addActionListener(new LaunchDssosListener() );
	}

	class LaunchSOSListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				readConfig(pathToSos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class LaunchDssosListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				readConfig(pathToDssos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readConfig(String path) throws IOException {
		FileInputStream fileIn = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fileIn);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		String data = "";
		int lines = 0;
		while ((strLine = br.readLine()) != null) {
			lines++;
			data += "\n" + strLine;

		}
		in.close();
		conf = new TextArea(data, lines, 80, TextArea.SCROLLBARS_VERTICAL_ONLY);
		conf.setEditable(false);
		add(conf);

	}

}
