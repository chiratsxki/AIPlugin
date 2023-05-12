package com.chiratsxki.projectleyla;

import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.impl.CaretModelImpl;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class AskQuestionAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        BrowserUtil.browse("https://www.perplexity.ai/search");
    }


}
