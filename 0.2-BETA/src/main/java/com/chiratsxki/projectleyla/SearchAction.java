package com.chiratsxki.projectleyla;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.ui.JBColor;
import com.intellij.ui.jcef.JBCefBrowser;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();

        String url = "https://www.perplexity.ai/search?q=" + selectedText;





        JFrame frame = new JFrame("Project Leyla");

        JBCefBrowser browser = new JBCefBrowser();
        frame.add(browser.getComponent());

        frame.setUndecorated(true);
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(closeButton, BorderLayout.SOUTH);
        frame.pack();

        frame.setSize(526, 570);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screenSize.getWidth() - frame.getWidth());
        int y = 85;
        frame.setLocation(x, y);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);






        browser.loadURL(url);

    }

    @Override
    public void update(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        e.getPresentation().setEnabledAndVisible(caretModel.getCurrentCaret().hasSelection());
    }
}
