namespace ModbusDemo
{
    partial class FormModbus
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btn_Connect = new Button();
            btn_ReadReg = new Button();
            listBox1 = new ListBox();
            btn_ReadOutCoil = new Button();
            btn_ReadInCoil = new Button();
            btn_ForceCoil = new Button();
            btn_SetSingleReg = new Button();
            btn_SetDoubleReg = new Button();
            SuspendLayout();
            // 
            // btn_Connect
            // 
            btn_Connect.Location = new Point(59, 76);
            btn_Connect.Name = "btn_Connect";
            btn_Connect.Size = new Size(108, 33);
            btn_Connect.TabIndex = 0;
            btn_Connect.Text = "连接串口";
            btn_Connect.UseVisualStyleBackColor = true;
            btn_Connect.Click += btn_Connect_Click;
            // 
            // btn_ReadReg
            // 
            btn_ReadReg.Location = new Point(193, 76);
            btn_ReadReg.Name = "btn_ReadReg";
            btn_ReadReg.Size = new Size(108, 33);
            btn_ReadReg.TabIndex = 1;
            btn_ReadReg.Text = "读取寄存器";
            btn_ReadReg.UseVisualStyleBackColor = true;
            btn_ReadReg.Click += btn_ReadReg_Click;
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.ItemHeight = 17;
            listBox1.Location = new Point(59, 190);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(652, 191);
            listBox1.TabIndex = 2;
            // 
            // btn_ReadOutCoil
            // 
            btn_ReadOutCoil.Location = new Point(334, 76);
            btn_ReadOutCoil.Name = "btn_ReadOutCoil";
            btn_ReadOutCoil.Size = new Size(92, 33);
            btn_ReadOutCoil.TabIndex = 0;
            btn_ReadOutCoil.Text = "读取输出线圈";
            btn_ReadOutCoil.Click += btn_ReadOutCoil_Click;
            // 
            // btn_ReadInCoil
            // 
            btn_ReadInCoil.Location = new Point(453, 76);
            btn_ReadInCoil.Name = "btn_ReadInCoil";
            btn_ReadInCoil.Size = new Size(108, 33);
            btn_ReadInCoil.TabIndex = 3;
            btn_ReadInCoil.Text = "读取输入线圈";
            btn_ReadInCoil.UseVisualStyleBackColor = true;
            btn_ReadInCoil.Click += btn_ReadInCoil_Click;
            // 
            // btn_ForceCoil
            // 
            btn_ForceCoil.Location = new Point(603, 76);
            btn_ForceCoil.Name = "btn_ForceCoil";
            btn_ForceCoil.Size = new Size(108, 33);
            btn_ForceCoil.TabIndex = 4;
            btn_ForceCoil.Text = "强制线圈";
            btn_ForceCoil.UseVisualStyleBackColor = true;
            btn_ForceCoil.Click += btn_ForceCoil_Click;
            // 
            // btn_SetSingleReg
            // 
            btn_SetSingleReg.Location = new Point(59, 129);
            btn_SetSingleReg.Name = "btn_SetSingleReg";
            btn_SetSingleReg.Size = new Size(108, 33);
            btn_SetSingleReg.TabIndex = 5;
            btn_SetSingleReg.Text = "写入单寄存器";
            btn_SetSingleReg.UseVisualStyleBackColor = true;
            btn_SetSingleReg.Click += btn_SetSingleReg_Click;
            // 
            // btn_SetDoubleReg
            // 
            btn_SetDoubleReg.Location = new Point(193, 129);
            btn_SetDoubleReg.Name = "btn_SetDoubleReg";
            btn_SetDoubleReg.Size = new Size(108, 33);
            btn_SetDoubleReg.TabIndex = 6;
            btn_SetDoubleReg.Text = "写入双寄存器";
            btn_SetDoubleReg.UseVisualStyleBackColor = true;
            btn_SetDoubleReg.Click += btn_SetDoubleReg_Click;
            // 
            // FormModbus
            // 
            AutoScaleDimensions = new SizeF(7F, 17F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btn_SetDoubleReg);
            Controls.Add(btn_SetSingleReg);
            Controls.Add(btn_ForceCoil);
            Controls.Add(btn_ReadInCoil);
            Controls.Add(btn_ReadOutCoil);
            Controls.Add(listBox1);
            Controls.Add(btn_ReadReg);
            Controls.Add(btn_Connect);
            Name = "FormModbus";
            Text = "Modbus仿真";
            ResumeLayout(false);
        }

        #endregion

        private Button btn_Connect;
        private Button btn_ReadReg;
        private ListBox listBox1;
        private Button btn_ReadOutCoil;
        private Button btn_ReadInCoil;
        private Button btn_ForceCoil;
        private Button btn_SetSingleReg;
        private Button btn_SetDoubleReg;
    }
}