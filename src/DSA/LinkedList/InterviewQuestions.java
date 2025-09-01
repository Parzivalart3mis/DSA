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

        public ListNode middleNode(ListNode head) {
            ListNode f = head;
            ListNode s = head;

            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
            }
            return s;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode prev = null;
            ListNode present = head;
            ListNode next = present.next;

            while (present != null) {
                present.next = prev;
                prev = present;
                present = next;
                if (next != null) {
                    next = next.next;
                }
            }
            return prev;
        }

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }

            // Skip the first left - 1 nodes
            ListNode current = head;
            ListNode prev = null;
            for (int i = 0; current != null && i < left - 1; i++) {
                prev = current;
                current = current.next;
            }
            ListNode last = prev;
            ListNode newEnd = current;

            // Reverse between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < right - left + 1; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            }
            else {
                head = prev;
            }
            newEnd.next = current;
            return head;
        }

        public boolean isPalindrome(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode headSecond = reverseList(mid);
            ListNode rereverseHead = headSecond;

            // Compare both the halves
            while (head != null && headSecond != null) {
                if (head.value != headSecond.value) {
                    break;
                }
                head = head.next;
                headSecond = headSecond.next;
            }
            reverseList(rereverseHead);

            if (head == null || headSecond == null) {
                return true;
            }
            return false; 
        }

        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode mid = middleNode(head);
            ListNode hs = reverseList(mid);
            ListNode hf = head;

            // Rearrange
            while (hf != null && hs != null) {
                ListNode temp = hf.next;
                hf.next = hs;
                hf = temp;

                temp = hs.next;
                hs.next = hf;
                hs = temp;
            }

            // Setting next of tail to null
            if (hf != null) {
                hf.next = null;
            }
        }

        // It is also reversing the < k end items -> Modify it accordingly
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1 || head == null) {
                return head;
            }

            // Skip the first left - 1 nodes
            ListNode current = head;
            ListNode prev = null;

            while (true) {
                ListNode last = prev;
                ListNode newEnd = current;

                // Reverse between left and right
                ListNode next = current.next;
                for (int i = 0; current != null && i < k; i++) {
                    current.next = prev;
                    prev = current;
                    current = next;
                    if (next != null) {
                        next = next.next;
                    }
                }

                if (last != null) {
                    last.next = prev;
                }
                else {
                    head = prev;
                }
                newEnd.next = current;

                if (current == null) {
                    break;
                }

                prev = newEnd;
            }
            return head;
        }
    }
}
