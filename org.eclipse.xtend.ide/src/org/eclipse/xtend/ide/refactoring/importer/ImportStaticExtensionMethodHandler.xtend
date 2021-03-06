/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring.importer

import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.text.ITextSelection
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil

import static extension org.eclipse.xtext.ui.editor.utils.EditorUtils.getActiveXtextEditor

/**
 * @author vivien.jovet - Initial contribution and API
 */
class ImportStaticExtensionMethodHandler extends AbstractHandler {

    @Inject
    SyncUtil syncUtil

    @Inject
    extension StaticExtensionMethodImporter importer

    override execute(ExecutionEvent event) throws ExecutionException {
        syncUtil.totalSync(false)
        val editor = event.activeXtextEditor
        if (editor !== null) {
            val selection = editor.selectionProvider.selection as ITextSelection
            val document = editor.document
            document.importStaticMethod(selection)
        }

        null
    }

}
