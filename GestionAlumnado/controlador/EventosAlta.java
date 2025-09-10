import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosAlta {
	
	private PanelAltas altas;
	
	public EventosAlta(PanelAltas altas) {
		this.altas=altas;
		
		altas.getBtnAlta().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		altas.getBtnLimpiar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				altas.getTxtClave().setText("");
				altas.getTxtNombre().setText("");
				altas.getTxtApellidos().setText("");
				altas.getTxtEdad().setText("");
				altas.getTxtCalle().setText("");
				altas.getTxtNumero().setText("");
				altas.getTxtCp().setText("");
			
		
			}
		});
	}
}
