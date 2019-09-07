/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.navigator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileContentProvider implements ITreeContentProvider {
  @Inject
  private IBuilderState builderState;
  
  @Override
  public Object[] getChildren(final Object parentElement) {
    return null;
  }
  
  public List<Object> getChildren(final IFile file) {
    List<Object> _xblockexpression = null;
    {
      String _fileExtension = file.getFileExtension();
      boolean _equals = Objects.equal(_fileExtension, "xtend");
      if (_equals) {
        final IResourceDescription resourceDescription = this.builderState.getResourceDescription(
          URI.createPlatformResourceURI(file.getFullPath().toString(), false));
      }
      _xblockexpression = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
    }
    return _xblockexpression;
  }
  
  @Override
  public Object[] getElements(final Object inputElement) {
    return new Object[] {};
  }
  
  @Override
  public Object getParent(final Object element) {
    return Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
  }
  
  @Override
  public boolean hasChildren(final Object element) {
    boolean _xifexpression = false;
    if ((element instanceof IFile)) {
      String _fileExtension = ((IFile)element).getFileExtension();
      _xifexpression = Objects.equal(_fileExtension, "xtend");
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
}
