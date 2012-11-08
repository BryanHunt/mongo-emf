/*******************************************************************************
 * Copyright (c) 2012 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.mongo.emf.log.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

/**
 * @author bhunt
 * 
 */
public class LogView extends ViewPart
{
	private TableViewer viewer;

	@Override
	public void createPartControl(Composite parent)
	{
		parent.setLayout(new FillLayout());

		viewer = new TableViewer(parent);
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn dateColumn = new TableColumn(table, SWT.LEFT);
		dateColumn.setText("Date");
		dateColumn.setWidth(100);

		TableColumn levelColumn = new TableColumn(table, SWT.LEFT);
		levelColumn.setText("Level");
		levelColumn.setWidth(100);

		TableColumn messageColumn = new TableColumn(table, SWT.LEFT);
		messageColumn.setText("Message");
		messageColumn.setWidth(500);
	}

	@Override
	public void setFocus()
	{
		viewer.getTable().setFocus();
	}

	public void refresh()
	{

	}
}
