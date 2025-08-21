package DSA.LinkedList;

public class InterviewQuestions {
    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        // Questions
        public ListNode deleteDuplicates(ListNode head) {
            ListNode temp;
            temp = head;
            while (temp != null) {
                if (temp.next != null && temp.value == temp.next.value) {
                    temp.next = temp.next.next;
                    size--;
                } else {
                    temp = temp.next;
                }
            }
            return head;
        }

        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }

        // Find the length of the cycle
        public int lengthCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    // Calculate the length
                    ListNode temp = slow;
                    int length = 0;
                    do {
                        temp = temp.next;
                        length++;
                    } while (temp != slow);
                    return length;
                }
            }
            return 0;
        }

        // Detect the start of cycle
        public ListNode detectCycle(ListNode head) {
            int length = 0;
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    length = lengthCycle(slow);
                    break;
                }
            }

            if (length == 0) {
                return null;
            }

            // Find the start node
            ListNode f = head;
            ListNode s = head;
            while (length > 0) {
                s = s.next;
                length--;
            }
            // Keep moving both forward, and they will meet at cycle start
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return s;
        }

        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;

            do {
                slow = findsquare(slow);
                fast = findsquare(findsquare(fast));
            } while (slow != fast);

            if (slow == 1) {
                return true;
            }
            return false;
        }

        private int findsquare(int number) {
            int ans = 0;
            while (number > 0) {
                int rem = number % 10;
                ans = ans + (rem * rem);
                number /= 10;
            }
            return ans;
        }

        public ListNode middleListNode(ListNode head) {
            ListNode f = head;
            ListNode s = head;

            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
            }
            return s;
        }
    }
}
