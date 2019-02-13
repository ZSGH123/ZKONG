package AgentDesignMode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ÷–ΩÈ
 * @author ÷”«ø
 *
 */
public class Proxy implements List{

	private List list;
	
	public Proxy(List list) {
		this.list=list;
	}

	@Override
	public int size() {
		System.out.println("size:"+new Date());
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		System.out.println("isEmpty:"+new Date());
		return this.list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		System.out.println("contains:"+new Date());
		return this.list.contains(o);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		System.out.println("add:"+new Date());
		return this.list.add(e);
	}

	@Override
	public boolean remove(Object o) {
		System.out.println("remove"+new Date());
		return this.list.remove(o);
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		System.out.println("addAll(Collection c)"+new Date());
		return this.list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection c) {
		System.out.println("addAll"+new Date());
		return this.list.addAll(index,c);
	}

	@Override
	public boolean removeAll(Collection c) {
		System.out.println("removeAll"+new Date());
		return this.list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c) {
		System.out.println("retainAll"+new Date());
		return this.list.retainAll(c);
	}

	@Override
	public void clear() {
		System.out.println("clear"+new Date());
		this.list.clear();
	}

	@Override
	public Object get(int index) {
		System.out.println("get"+new Date());
		return this.list.get(index);
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(int index) {
		System.out.println("remove"+new Date());
		return this.list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
