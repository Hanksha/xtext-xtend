/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.navigator;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileLabelProvider extends LabelProvider {
  @Override
  public String getText(final Object element) {
    return element.toString();
  }
}
