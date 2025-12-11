package Frontend;

import javax.swing.*;

import Backend.SolicitudesAlta;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSolicitarAlta {
	// Método que devuelve un panel
	public static JPanel crearPanel() {
		JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelPrincipal.setBackground(new Color(161,223,182));

		// ComboBox y botón
		JPanel formulario = new JPanel(new GridLayout(2, 2, 10, 10));
		formulario.setBorder(BorderFactory.createTitledBorder("Solicitar Alta de Paciente"));
		formulario.setBackground(new Color(161,223,182));
		
		JComboBox<String> comboPacientes = new JComboBox<>(new String[] { "Paciente 1", "Paciente 2", "Paciente 3" });
		JButton btnSolicitarAlta = new JButton("Solicitar Alta");
		comboPacientes.setBackground(new Color(255,255,255));
		
		btnSolicitarAlta.setBackground(new Color(102,205,170));


		formulario.add(new JLabel("Seleccionar Paciente:"));
		formulario.add(comboPacientes);
		formulario.add(new JLabel());
		formulario.add(btnSolicitarAlta);

		// Área de historial
		JTextArea areaSolicitudes = new JTextArea();
		areaSolicitudes.setEditable(false);
		areaSolicitudes.setBorder(BorderFactory.createTitledBorder("Solicitudes Realizadas"));
		JScrollPane scroll = new JScrollPane(areaSolicitudes);

		// Acción del botón
		btnSolicitarAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String paciente = (String) comboPacientes.getSelectedItem();
				if (paciente != null) {
					SolicitudesAlta.getSolicitudes().add(paciente);
					JOptionPane.showMessageDialog(panelPrincipal, "Alta solicitada para " + paciente);
					// Actualizar historial
					List<String> solicitudes = SolicitudesAlta.getSolicitudes();
					areaSolicitudes.setText("");
					for (String p : solicitudes) {
						areaSolicitudes.append("- " + p + "\n");
					}
				}
			}
		});

		panelPrincipal.add(formulario, BorderLayout.NORTH);
		panelPrincipal.add(scroll, BorderLayout.CENTER);

		return panelPrincipal;
	}

}
