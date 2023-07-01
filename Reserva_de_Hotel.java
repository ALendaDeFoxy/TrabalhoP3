package HoterlReserva;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reserva_de_Hotel {
    private JFrame frame;
    private JTextField HotelNomeTextField;
    private JTextField DatadeEntradaTextField;
    private JTextField DatadeSaidaTextField;
    private JSpinner adultosSpinner;
    private JSpinner CriançasSpinner;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Reserva_de_Hotel().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("Reserva de Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // NOME DO HOTEL
        JLabel HotelNomeLabel = new JLabel("Nome do Hotel:");
        HotelNomeTextField = new JTextField();
        panel.add(HotelNomeLabel);
        panel.add(HotelNomeTextField);

        // DATA DE ENTRADA NO HOTEL
        JLabel DatadeEntradaLabel = new JLabel("Data de Entrada (dd/mm/aaaa):");
        DatadeEntradaTextField = new JTextField();
        panel.add(DatadeEntradaLabel);
        panel.add(DatadeEntradaTextField);

        // DATA DE SAIDA
        JLabel DatadeSaidaLabel = new JLabel("Data de Saida (dd/mm/aaaa):");
        DatadeSaidaTextField = new JTextField();
        panel.add(DatadeSaidaLabel);
        panel.add(DatadeSaidaTextField);

        // QUANTOS ADULTOS
        JLabel adultosLabel = new JLabel("Adultos:");
        adultosSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        panel.add(adultosLabel);
        panel.add(adultosSpinner);

        // QUANTAS CRIANÇAS
        JLabel CriançasLabel = new JLabel("Crianças:");
        CriançasSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        panel.add(CriançasLabel);
        panel.add(CriançasSpinner);

        // FAZER A RESERVA
        JButton submitButton = new JButton("Fazer Reserva");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String HotelNome = HotelNomeTextField.getText();
                String DatadeEntrada = DatadeEntradaTextField.getText();
                String DatadeSaida = DatadeSaidaTextField.getText();
                int NumerodeAdultos = (int) adultosSpinner.getValue();
                int NumerodeCrianças = (int) CriançasSpinner.getValue();

                // Verificar se as datas de entrada e saída estão preenchidas
                if (DatadeEntrada.isEmpty() || DatadeSaida.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Por favor, preencha as datas de entrada e saída.",
                            "Campos Vazios",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Encerrar o processamento da reserva
                }

                // Processar a reserva do hotel com os dados fornecidos

                // MENSAGEM DE CONFIRMAÇÃO
                JOptionPane.showMessageDialog(frame,
                        "Reserva efetuada com sucesso!\n" +
                                "Hotel: " + HotelNome + "\n" +
                                "Entrada: " + DatadeEntrada + "\n" +
                                "Sainda: " + DatadeSaida + "\n" +
                                "Adultos: " + NumerodeAdultos + "\n" +
                                "Crianças: " + NumerodeCrianças,
                        "Reserva Efetuada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(submitButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}