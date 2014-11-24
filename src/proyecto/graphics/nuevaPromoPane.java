package proyecto.graphics;

import javax.swing.JPanel;

import proyecto.Componente;
import proyecto.ListaComponentes;

public class nuevaPromoPane extends JPanel {
	// Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration          
	/**
	 * Create the panel.
	 */
	public nuevaPromoPane(ListaComponentes c) {
	       jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jTextField3 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();

	        jLabel1.setText("First Number:");

	        jLabel2.setText("Second Number:");

	        jLabel3.setText("Result:");

	        jButton1.setText("Add");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("Subtract");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Multiply");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton4.setText("Divide");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });

	        jButton5.setText("Clear");
	        jButton5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton5ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(66, 66, 66)
	                .addComponent(jButton1)
	                .addGap(45, 45, 45)
	                .addComponent(jButton2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
	                .addComponent(jButton3)
	                .addGap(27, 27, 27))
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(39, 39, 39)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel1)
	                            .addComponent(jLabel2)
	                            .addComponent(jLabel3))
	                        .addGap(88, 88, 88)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
	                            .addComponent(jTextField2)
	                            .addComponent(jTextField3)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(120, 120, 120)
	                        .addComponent(jButton4)
	                        .addGap(45, 45, 45)
	                        .addComponent(jButton5)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(39, 39, 39)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(34, 34, 34)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton2)
	                    .addComponent(jButton3))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton4)
	                    .addComponent(jButton5))
	                .addContainerGap(67, Short.MAX_VALUE))
	        );
	    }// </editor-fold>                        

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        double num1, num2, result;
	        num1 = Double.parseDouble(jTextField1.getText());
	        num2 = Double.parseDouble(jTextField2.getText());
	        result = num1 + num2;
	        jTextField3.setText(String.valueOf(result));
	    }                                        

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        double num1, num2, result;
	        num1 = Double.parseDouble(jTextField1.getText());
	        num2 = Double.parseDouble(jTextField2.getText());
	        result = num1 - num2;
	        jTextField3.setText(String.valueOf(result));
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        double num1,num2, result;
	        num1 = Double.parseDouble(jTextField3.getText());
	        num2 = Double.parseDouble(jTextField2.getText());
	        result = num1*num2;
	        jTextField3.setText(String.valueOf(result));
	    }                                        

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        double num1, num2, result;
	        num1 = Double.parseDouble(jTextField1.getText());
	        num2 = Double.parseDouble(jTextField2.getText());
	        result = num1 / num2;

	    }                                        

	    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        jTextField1.setText("");
	        jTextField2.setText("");
	        jTextField3.setText("");
	    }   

}
