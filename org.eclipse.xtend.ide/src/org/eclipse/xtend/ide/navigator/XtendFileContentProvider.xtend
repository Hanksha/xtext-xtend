/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.navigator

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.xtext.builder.builderState.IBuilderState

/**
 * @author vivien.jovet - Initial contribution and API
 */
class XtendFileContentProvider implements ITreeContentProvider {

    @Inject
    IBuilderState builderState

    override getChildren(Object parentElement) {
    }

    def getChildren(IFile file) {
        if (file.fileExtension == 'xtend') {
            val resourceDescription = builderState.getResourceDescription(
                URI.createPlatformResourceURI(file.fullPath.toString, false))
        }
        #[]
    }

    override getElements(Object inputElement) {
        #[]
    }

    override getParent(Object element) {
        #[]
    }

    override hasChildren(Object element) {
        if (element instanceof IFile)
            element.fileExtension == 'xtend'
        else
            true
    }

}
