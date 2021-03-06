/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring.importer

import com.google.inject.Inject
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtend.ide.refactoring.importer.StaticExtensionMethodImporter
import org.eclipse.xtext.ui.editor.model.IXtextDocument

/**
 * Usage is:
 * 
 * <pre>
 * 'test.Test.xtend'.create('''
 *      package test
 *          
 *      import test.other.Other
 *          
 *      class Test {
 *          def test() {
 *              Other.doSo|mething('test')
 *          }
 *      }
 * ''').assertResult('''
 *      package test
 *          
 *      import static extension test.other.Other.doSomething
 *          
 *      class Test {
 *          def test() {
 *              'test'.doSomething()
 *          }
 *      }
 * ''')
 * </pre>
 * 
 * | or <|> are used to mark the selection in the document.
 * 
 * @author vivien.jovet - Initial contribution and API
 */
class StaticExtensionMethodImporterTestBuilder extends StaticMethodImporterTestBuilder {

    @Inject
    extension StaticExtensionMethodImporter staticExtensionMethodImporter

    override protected doImportStaticMethod(IXtextDocument document, int caretOffset) {
        document.importStaticMethod(new TextSelection(caretOffset, 1))
    }

}
