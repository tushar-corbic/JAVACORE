package org.example;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  };

  public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty() ){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre!=null && pre.val>=cur.val)
                return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
      public int kthSmallest(TreeNode root, int k) {
        int ans = -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || stack.isEmpty()==false){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur= stack.pop();
            if(k--==0){
                return cur.val;
            }
            cur= cur.right;
        }
        return ans;

    }
      public int numDecodings(String s) {
          return s.length()==0?0:numDecodinghelper(0,s);
      }
      public int numDecodings2(String s) {
        int n = s.length();
        Integer[] mem = new Integer[n];
          return s.length()==0?0:numDecodinghelper2(0,s, mem);
      }
      public int numDecodings3(String s) {
          int n = s.length();
          Integer[] mem = new Integer[n+1];
          mem[n] = 1;
          for(int i = n-1;i >=0; i--){
              if(s.charAt(i)=='0'){
                  mem[i]=0;
              }else{
                  mem[i]+=mem[i+1];
                  if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
                      mem[i]+=mem[i+2];
              }
          }
          return mem[0];
      }
      public int numDecodinghelper2(int index, String s, Integer[] mem){
        int n = s.length();
        if(index==n) return 1;
        if(s.charAt(index)=='0') return 0;
        if(mem[index]!=null) return mem[index];
        int res = numDecodinghelper2(index+1, s, mem);
        if(index<n-1 &&(s.charAt(index)=='1'||(s.charAt(index)=='2'&& s.charAt(index)<='6')))
            res+=numDecodinghelper2(index+2,s, mem);
          return mem[index] = res;
      }

      public int numDecodinghelper(int index, String s){
        int n = s.length();
        if(index==n) return 1;
        if(s.charAt(index)=='0') return 0;
        int res = numDecodinghelper(index+1, s);
        if(index<n-1 &&(s.charAt(index)==1 || (s.charAt(index)=='2' && s.charAt(index+1)<='7'))){
            res+= numDecodinghelper(index+2, s);
        }
        return res;
      }
      public void merge(int[] nums1, int m, int[] nums2, int n) {
          int k = m + n-1;
          int i = n-1;
          int j = m-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
        while (j>=0)
            nums1[k--] = nums2[j--];
      }
      public int largestRectangleArea(int[] heights) {
          int ans = Integer.MIN_VALUE;
          int n = heights.length;
          int[] firstsmallestleft = new int[n];
          int[] firstsmallestright = new int[n];
          firstsmallestleft[0] = -1;
          for (int i = 1; i < n; i++) {
              int p = i;
              while (p>=0 && heights[p]>=heights[i]){
                  p = firstsmallestleft[p];
              }
              firstsmallestleft[i]= p;
          }
          firstsmallestright[n-1] = n;
          for(int i = n-2; i>=0; i--){
              int p = i;
              while(p<n && heights[p]>=heights[i])
                  p= firstsmallestright[p];
              firstsmallestright[i]= p;
          }
          for(int i = 0; i<n; i++){
              ans = Math.max(ans, ((firstsmallestright[i]-firstsmallestleft[i])-1)*heights[i]);
          }
          return ans;
      }
      boolean helper(char[][]board, int x, int y, String word, int index){
        if(index==word.length()) return true;
        if(x<0 ||y<0 || x>=board.length || y>=board[x].length) return false;
        if(board[x][y]!=word.charAt(index)) return false;
        board[x][y] = '*';
        boolean result = helper(board, x+1, y, word, index+1) || helper(board, x-1, y, word, index+1) || helper(board,x, y+1, word, index+1) || helper(board, x, y-1, word, index+1);
        board[x][y] = word.charAt(index);
          return result;
      }

      public boolean exist(char[][] board, String word) {
        boolean result = false;
        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board[0].length;  j++){
                if(helper(board, i, j, word, 0))
                    return true;
            }
        }
        return result;
      }

      public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> temp) {
          if (index == nums.length)
              result.add(new ArrayList<>(temp));
          for (int i = index; i < nums.length; i++) {
              temp.add(nums[i]);
              helper(nums, index + 1, result, temp);
              temp.remove(temp.size() - 1);
          }
      }
      public List<List<Integer>> subsets(int[] nums) {
          Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, ans, temp);
        return ans;
      }
      public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper2(nums, 0, temp, ans);
        return ans;
      }
      public void helper2(int[] num, int index, List<Integer>temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i = index; i<num.length; i++){
            if(i>index && num[i-1]==num[i])
                    continue;
            temp.add(num[i]);
            helper2(num, i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
      void helper3(int[] arr, List<Integer> temp, List<List<Integer>> res){
          if(temp.size()==arr.length)
              res.add(new ArrayList<>(temp));
          else{
              for(int i = 0; i<arr.length; i++){
                  if(temp.contains(arr[i])) continue;
                  temp.add(arr[i]);
                  helper3(arr, temp, res);
                  temp.remove(temp.size()-1);
              }
          }
      }
      public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> res = new ArrayList<>();
          List<Integer> temp = new ArrayList<>();
          helper3(nums ,temp, res);
          return res;
      }

      public void sortColors(int[] A) {
          if(A==null || A.length<2) return;
          int low = 0;
          int high = A.length-1;
          for(int i = low; i<=high;) {
              if(A[i]==0) {
                  // swap A[i] and A[low] and i,low both ++
                  int temp = A[i];
                  A[i] = A[low];
                  A[low]=temp;
                  i++;low++;
              }else if(A[i]==2) {
                  //swap A[i] and A[high] and high--;
                  int temp = A[i];
                  A[i] = A[high];
                  A[high]=temp;
                  high--;
              }else {
                  i++;
              }
          }
      }



}