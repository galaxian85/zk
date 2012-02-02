/* TreeDataEvent.java

	Purpose:
		
	Description:
		
	History:
		Aug 10 2007, Created by tomyeh

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under LGPL Version 2.1 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zul.event;

import org.zkoss.zul.TreeModel;

/**
 * Defines an event that encapsulates changes to a tree. 
 *
 * @author Jeff Liu
 * @since 3.0.0
 */
public class TreeDataEvent<E> {
	/** Identifies changing contents of nodes. */
	public static final int CONTENTS_CHANGED = 0;
	/** Identifies the addition of children to a node. */    
	public static final int INTERVAL_ADDED = 1;
	/** Identifies the removal of children to a node. */   
	public static final int INTERVAL_REMOVED = 2;
	/** Identifies the structure of the tree has changed. @since 5.0.6  */
	public static final int STRUCTURE_CHANGED = 3;
	/** Identifies the selection of the tree has changed. @since 6.0.0  */
	public static final int SELECTION_CHANGED = 4;
	/** Identifies the open status of the tree has changed. @since 6.0.0  */
	public static final int OPEN_CHANGED = 5;
	/** Identified the state of {@link ListModel#isMultiple} is changed.
	 * @since 6.0.0
	 */
	public static final int MULTIPLE_CHANGED = 6;

	private final TreeModel<E> _model;
	private final int _type;
	private final int _indexFrom;
	private final int _indexTo;
	private final E _parent;

	/** Contructor.
	 *
	 * @param type one of {@link #CONTENTS_CHANGED},
	 * {@link #INTERVAL_ADDED}, or {@link #INTERVAL_REMOVED}.
	 * @param parent - the parent node that its children being modified .
	 * @param indexFrom the lower index of the change range
	 * @param indexTo the upper index of the change range
	 */
	public TreeDataEvent(TreeModel<E> model, int type, E parent, int indexFrom, int indexTo) {
		_model = model;
		_type = type;
		_parent = parent;
		_indexFrom = indexFrom;
		_indexTo = indexTo;
	}
	
	/** Returns the tree model that fires this event.
	 */
	public TreeModel getModel() {
		return _model;
	}
	
	/** Returns the event type. One of {@link #CONTENTS_CHANGED},
	 * {@link #INTERVAL_ADDED}, or {@link #INTERVAL_REMOVED}.
	 */
	public int getType() {
		return _type;
	}
	
	/**
	 * Returns the parent node that one of its children being modified 
	 * @return the parent node that one of its children being modified 
	 */
	public E getParent(){
		return _parent;
	}
	
	/**
	 * Return the lower index of the change range
	 * @return the lower index of the change range
	 */ 
	public int getIndexFrom(){
		return _indexFrom;
	}
	
	/**
	 * Return the upper index of the change range
	 * @return the upper index of the change range
	 */
	public int getIndexTo(){
		return _indexTo;
	}

}
