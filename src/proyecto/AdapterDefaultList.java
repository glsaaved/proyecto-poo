package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.EventListener;

import javax.swing.ListModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class AdapterDefaultList extends ListaLocales implements ListModel,Serializable {
	protected EventListenerList listenerList;
	public AdapterDefaultList()
	{
		super();
		listenerList = new EventListenerList();
	}

	@Override
	public Object getElementAt(int i) {
		return super.search(i);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return super.size();
	}

	@Override
	public Object search(String s) {
		return super.search(s);
	}

	public void addElement(String string) {
		int index=super.size();
		super.crearLocal(string);
		fireIntervalAdded(this,index,index);
		
	}
	public boolean loadFile(File f) throws FileNotFoundException, IOException, loadFileException
	{
		boolean b=super.loadFile(f);
		fireIntervalAdded(this,super.size(),super.size());
		return b;
	}
	public Object remove(int index) {
		Object o=super.search(index);
		super.delete(o);
		fireIntervalRemoved(this,index,index);
		return o;
		
	}
	public void add(int index, String newitem) {
		super.crearLocal(newitem);
		fireIntervalAdded(this,index,index);
		
	}
	public void add(int index, String newitem, int id) {
		super.crearLocal(newitem,index,id);
		fireIntervalAdded(this,index,index);
		
	}
	public void clear() {
		int index1=super.size()-1;
		super.deleteAll();
		if(index1>=0)
		{
			fireIntervalRemoved(this,0,index1);
		}
		
	}
	 /**
	     * Adds a listener to the list that's notified each time a change
	     * to the data model occurs.
	     *
	     * @param l the <code>ListDataListener</code> to be added
	     */
	    public void addListDataListener(ListDataListener l) {
	        listenerList.add(ListDataListener.class, l);
	    }
	    /**
	     * Removes a listener from the list that's notified each time a
	     * change to the data model occurs.
	     *
	     * @param l the <code>ListDataListener</code> to be removed
	     */
	    public void removeListDataListener(ListDataListener l) {
	        listenerList.remove(ListDataListener.class, l);
	    }


	    /**
	     * Returns an array of all the list data listeners
	     * registered on this <code>AbstractListModel</code>.
	     *
	     * @return all of this model's <code>ListDataListener</code>s,
	     *         or an empty array if no list data listeners
	     *         are currently registered
	     *
	     * @see #addListDataListener
	     * @see #removeListDataListener
	     *
	     * @since 1.4
	     */
	    public ListDataListener[] getListDataListeners() {
	        return (ListDataListener[])listenerList.getListeners(
	                ListDataListener.class);
	    }


	    /**
	     * <code>AbstractListModel</code> subclasses must call this method
	     * <b>after</b>
	     * one or more elements of the list change.  The changed elements
	     * are specified by the closed interval index0, index1 -- the endpoints
	     * are included.  Note that
	     * index0 need not be less than or equal to index1.
	     *
	     * @param source the <code>ListModel</code> that changed, typically "this"
	     * @param index0 one end of the new interval
	     * @param index1 the other end of the new interval
	     * @see EventListenerList
	     * @see DefaultListModel
	     */
	    protected void fireContentsChanged(Object source, int index0, int index1)
	    {
	        Object[] listeners = listenerList.getListenerList();
	        ListDataEvent e = null;

	        for (int i = listeners.length - 2; i >= 0; i -= 2) {
	            if (listeners[i] == ListDataListener.class) {
	                if (e == null) {
	                    e = new ListDataEvent(source, ListDataEvent.CONTENTS_CHANGED, index0, index1);
	                }
	                ((ListDataListener)listeners[i+1]).contentsChanged(e);
	            }
	        }
	    }


	    /**
	     * <code>AbstractListModel</code> subclasses must call this method
	     * <b>after</b>
	     * one or more elements are added to the model.  The new elements
	     * are specified by a closed interval index0, index1 -- the enpoints
	     * are included.  Note that
	     * index0 need not be less than or equal to index1.
	     *
	     * @param source the <code>ListModel</code> that changed, typically "this"
	     * @param index0 one end of the new interval
	     * @param index1 the other end of the new interval
	     * @see EventListenerList
	     * @see DefaultListModel
	     */
	    protected void fireIntervalAdded(Object source, int index0, int index1)
	    {
	        Object[] listeners = listenerList.getListenerList();
	        ListDataEvent e = null;

	        for (int i = listeners.length - 2; i >= 0; i -= 2) {
	            if (listeners[i] == ListDataListener.class) {
	                if (e == null) {
	                    e = new ListDataEvent(source, ListDataEvent.INTERVAL_ADDED, index0, index1);
	                }
	                ((ListDataListener)listeners[i+1]).intervalAdded(e);
	            }
	        }
	    }


	    /**
	     * <code>AbstractListModel</code> subclasses must call this method
	     * <b>after</b> one or more elements are removed from the model.
	     * <code>index0</code> and <code>index1</code> are the end points
	     * of the interval that's been removed.  Note that <code>index0</code>
	     * need not be less than or equal to <code>index1</code>.
	     *
	     * @param source the <code>ListModel</code> that changed, typically "this"
	     * @param index0 one end of the removed interval,
	     *               including <code>index0</code>
	     * @param index1 the other end of the removed interval,
	     *               including <code>index1</code>
	     * @see EventListenerList
	     * @see DefaultListModel
	     */
	    protected void fireIntervalRemoved(Object source, int index0, int index1)
	    {
	        Object[] listeners = listenerList.getListenerList();
	        ListDataEvent e = null;

	        for (int i = listeners.length - 2; i >= 0; i -= 2) {
	            if (listeners[i] == ListDataListener.class) {
	                if (e == null) {
	                    e = new ListDataEvent(source, ListDataEvent.INTERVAL_REMOVED, index0, index1);
	                }
	                ((ListDataListener)listeners[i+1]).intervalRemoved(e);
	            }
	        }
	    }

	    /**
	     * Returns an array of all the objects currently registered as
	     * <code><em>Foo</em>Listener</code>s
	     * upon this model.
	     * <code><em>Foo</em>Listener</code>s
	     * are registered using the <code>add<em>Foo</em>Listener</code> method.
	     * <p>
	     * You can specify the <code>listenerType</code> argument
	     * with a class literal, such as <code><em>Foo</em>Listener.class</code>.
	     * For example, you can query a list model
	     * <code>m</code>
	     * for its list data listeners
	     * with the following code:
	     *
	     * <pre>ListDataListener[] ldls = (ListDataListener[])(m.getListeners(ListDataListener.class));</pre>
	     *
	     * If no such listeners exist,
	     * this method returns an empty array.
	     *
	     * @param listenerType  the type of listeners requested;
	     *          this parameter should specify an interface
	     *          that descends from <code>java.util.EventListener</code>
	     * @return an array of all objects registered as
	     *          <code><em>Foo</em>Listener</code>s
	     *          on this model,
	     *          or an empty array if no such
	     *          listeners have been added
	     * @exception ClassCastException if <code>listenerType</code> doesn't
	     *          specify a class or interface that implements
	     *          <code>java.util.EventListener</code>
	     *
	     * @see #getListDataListeners
	     *
	     * @since 1.3
	     */
	    public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
	        return listenerList.getListeners(listenerType);
	    }

		public boolean saveFile(File f) throws saveFileException, FileNotFoundException, UnsupportedEncodingException {
			return super.saveFile(f);
			
		}



}