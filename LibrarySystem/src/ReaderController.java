import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderController implements ActionListener {

    ReaderView readerView;

    public ReaderController(ReaderView readerView) {
        this.readerView = readerView;
        //readerView.btnExit.addActionListener(this);
        readerView.btnRecord.addActionListener(this);
        readerView.btnBorrow.addActionListener(this);
        readerView.btnInfo.addActionListener(this);
        readerView.btnSaveReader.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == readerView.btnBorrow) {
            LibraryManager.borrowView.show();
            LibraryManager.readerView.dispose();
        }
        if (e.getSource() == readerView.btnInfo) {
            LibraryManager.bookView.show();
            LibraryManager.readerView.dispose();
        }
        if (e.getSource() == readerView.btnSaveReader) {
            LibraryManager.addReaderView.show();
            LibraryManager.readerView.dispose();
        }
        if (e.getSource() == readerView.btnRecord) {
            LibraryManager.recordView.show();
            LibraryManager.readerView.dispose();
        }
        /*if (e.getSource() == readerView.btnExit) {
           System.exit(0);
        }*/
    }
}
