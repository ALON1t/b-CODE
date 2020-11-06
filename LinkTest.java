package Link;

import java.util.List;

public class LinkTest {
    public ListNode head;

    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void removeAllKey(int key) {

    }

    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode  partition(int x) {
        //小于x的部分
        ListNode bs = null; //头
        ListNode be = null; //尾
        //大于x的部分
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val < x) {
                if(bs == null) {//第一次插入--尾插
                    bs = cur;
                    be = as;
                } else {
                    bs.next = cur;
                    be = cur;
                }

            } else {
                if(as == null) {//第一次插入--尾插
                    as = cur;
                    ae = as;
                } else {
                    as.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {//无小于x的结点
            return as;//直接返回大于x的链表的头结点 as
        }
        be.next = as;//不等于空 则将两个链表连接起来
        if(as != null) {
            ae.next = null; //最后一个结点的next域为null
        }
        return bs;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    public ListNode deleteDuplication() {
        ListNode newHead = new ListNode(-1);//傀儡节点（最后返回傀儡节点的下一个--头结点）
        ListNode cur = this.head;
        ListNode tmp = newHead;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;//多个重复的结点,找完之后，cur指向最后一个相同的需要删除的结点
                }
                cur = cur.next;//找完之后，需要指向下一个结点
            }else {// 除相同值的结点
                tmp.next = cur;
                tmp = cur;
                cur = cur.next;
                }
        }

        tmp.next = null;//防止最后两个结点相等
        return newHead.next;
    }

    //链表的回文结构的判断
    public boolean chkPalindrome() {
        if(this.head == null) {
            return false;
        }
        if(this.head.next == null) {//一个结点
            return true;
        }
        //1.找到中间结点slow
        ListNode fast = this.head;//快慢指针
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.反转
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.判断val值是否相同
        //一个从前往后走，一个从后往前走
        while(this.head != slow) {
            if(this.head.val != slow.val) {
                return false;
            }
            if(this.head.next == slow) {//偶数结点时
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    //给定一个链表，判断链表中是否有环
    //定义两个引用，一个引用走一步，一个引用走两步，如果两个引用最后相遇，则代表该链表有环
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        return true;
    }

    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle() {
        //假设起点到入口点的位置为X 圈长度为C L代表入口点到相遇点的距离 N代表圈数
        //相遇时fast所走的路程时slow所走路程的两倍
        //slow:X+L
        //fast：X+L+NC
        //2(X+L) = X+L+NC --(与N无关，取N=1)
        //X=C-L
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;//没有环
        }
        slow = this.head;
        while(slow != fast) { //fast在相遇点，
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public  int size (ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode head1,ListNode head2) {
        //相交的链表的形状是横着的Y
        //相交 即next域指向相同
        //如果两个链表长度不一样，如果两个链表相交，那么他们的长度差，必然在相交点的前半部分
        //步骤：
        //1.分别求出两个链表的长度
        //2.让最长的链表走两个链表的差值步
        //3.两个引用同时开始走，如果相遇，说明两个链表相交
        if(head1 == null || head2 == null) {
            return null;
        }
        ListNode pl = head1; //长
        ListNode ps = head2;// 短
        int len1 = 0;
        int len2 = 0;
        while(pl != null) {//链表1的长度
            len1++;
            pl = pl.next;
        }

        while(ps != null) {//链表2的长度
            len2++;
            ps = ps.next;
        }
        //循环结束后，pl,ps指向改变（为null），需要重新指回头结点
        pl = head1;
        ps = head2;
        int len = len1 - len2;//找出长度较长的链表
        if(len < 0) {  //链表2较长
            ps = head1;
            pl = head2;//保证p1指向长链表，p2指向短链表
            len = len1 - len2;//保证len为正
        }
        while(len > 0) {//pl先走差值步
            len--;
            pl = pl.next;
        }
        while(pl != null & ps != null && pl != ps) {//在pl,ps同时一步一步走
            pl = pl.next;
            ps = ps.next;
        }

        //相交即返回pl或ps
        if(pl == ps && pl != null) {
            return pl;
        }
        //未找到
        return null;
    }

    public ListNode mergeTwoLists(ListNode p1,ListNode p2) {

        ListNode newHead = new ListNode(-1);//定义一个傀儡结点
        ListNode tmp = newHead;
        while(p1 != null && p2 != null) {
            if(p1.val > p2.val) {
                tmp.next = p2;
                tmp = p2;
                p2 = p2.next;
            } else {
                tmp.next = p1;
                tmp = p1;
                p1 = p1.next;
            }
        }
        if(p2 == null) {//p1剩下的val值都比之前的值大
            tmp.next = p1;
        }
        if(p1 == null) {//p2剩下的val值都比之前的值大
            tmp.next = p2;
        }
        return newHead.next;
    }

    public ListNode removeAllKeys(int key) {
        if(head == null){
            return  null;
        }
        ListNode cur = this.head.next;
        ListNode prev = this.head;
        while(cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        if(this.head.val == key) {
            this.head = this.head.next;
        }
        return  this.head;
    }

    public ListNode reveseList() {
        ListNode cur  = this.head;
        ListNode prev = null;
        while(cur != null ) {
            ListNode nextCur = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextCur;
        }
        return prev;
    }

    public ListNode FindKthToTail(int k) {
        if(k <= 0 || this.head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k - 1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                return null;
            }
        }
        while(fast.next != null ) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode middleNode() {
        //快慢指针
        ListNode fast = this.head;
        ListNode slow = this.head;
        if(head == null) {
            return null;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



}
