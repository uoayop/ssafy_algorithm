package com.ssafy.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1228_8일차_암호문1 {
	static class Node{
		public String num;
		public Node next;
		
		public Node(String num) {
			this.num = num;
		}
		
		public Node(String num, Node next) {
			this(num);
			this.next = next;
		}
	}
	
	static class LinkedList{
		private Node head;
		
		public void addFirstNode(String data) {
			Node newNode = new Node(data, head);
			head = newNode;
		}
		
		public Node getLastNode() {
			for (Node currNode = head; currNode!=null; currNode=currNode.next) {
				if (currNode.next == null) {
					return currNode;
				}
			}
			return null;
		}
		
		public void addNode(String data) {
			if (head == null) {
				addFirstNode(data);
				return;
			} 
			Node lastNode = getLastNode();
			Node newNode = new Node(data,null);
			lastNode.next = newNode;
		}
		
		public void insertNode(int index, String data) {
			Node currNode = head;
			
			if (index <= 0) {
				Node newNode = new Node(data, head);
				head = newNode;
				return;
			}
			
			for (int i=0; i<index-1; i++) {
				currNode = currNode.next;
			}
			
			Node newNode = new Node(data, currNode.next);
			currNode.next = newNode;
		}
		
		public void printlst() {
			Node currNode = head;
			for (int i=0; i<10; i++) {
				System.out.print(currNode.num+" ");
				currNode = currNode.next;
			}
			return;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t=1; t<=10; t++) {
			LinkedList lst = new LinkedList();
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				lst.addNode(st.nextToken());
			}
			
//			System.out.println();
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(),"I");
//			
			while (st.hasMoreTokens()) {
				StringTokenizer subst = new StringTokenizer(st.nextToken()," ");
				int index = Integer.parseInt(subst.nextToken());
				int length = Integer.parseInt(subst.nextToken());
				
				for (int j=0; j<length; j++) {
					String target = subst.nextToken();
					lst.insertNode(index++, target);
				}
	 		}
			
			System.out.printf("#%d ",t);
			lst.printlst();
			System.out.println();
		}
	}
}
