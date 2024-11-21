class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 创建新的排列组合链表
        List<List<Integer>> res = new ArrayList<>();

        //对数组进行排序, 方便回溯时的去重(遇到相同元素直接跳过)
        Arrays.sort(nums);

        // 边界判断
        if (nums.length == 0) {
            return res;
        }

        // 调用递归函数, 遍历数组
        collectSubset(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void collectSubset(int[] nums, int start, List<Integer> subList, List<List<Integer>> res) {
        // 当start大于数组长度时, 数组中所有元素都添加完, 跳出这次递归
        if (start > nums.length) {
            return;
        }

        // 每次都将当前子集添加到res中, 从空开始
        res.add(new ArrayList<Integer>(subList));

        // 回溯顺序
        // System.out.println(subList.toString());

        // 从索引0开始,将所有包含当前值的情况全部添加到res中
        // 第二次运行时, 用i+1递归, 所以添加的是从当前值开始, 所有的可能组合
        // 回溯模板
        for (int i = start; i < nums.length; i++) {
            //如果i>index说明candidates[index]的情况已经遍历过了, 此时是第二次遍历
            //第二次遍历时, 如果当前值和前一个索引的值相同, 跳过该循环,
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 将 i 添加到list中,(从索引0开始)
            subList.add(nums[i]);

            // 回溯遍历从当前元素到数组结尾的所有可能性
            collectSubset(nums, i + 1, subList, res);

            // 删除最后一个元素
            subList.remove(subList.size() - 1);

        }

    }
}