package leetcode.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddTwoNumbersTest {
    private static final Logger logger = LoggerFactory.getLogger(AddTwoNumbersTest.class);

    static final AddTwoNumbers classUnderTest = new AddTwoNumbers();

    @DisplayName("Single test")
    @Test
    void addTwoNumsTest() {
        ListNode node1 = fromList(1, 2, 4);
        ListNode node2 = fromList(4, 5, 6);
        //421+654= 1075
        ListNode result = fromList(5, 7, 0, 1);
        assertEquals(result, classUnderTest.addTwoNumbers(node1, node2));
    }

    @DisplayName("Multiple tests")
    @ParameterizedTest
    @MethodSource("inputsAndResultProvider")
    void addTwoNumsMultiTest(ListNode l1, ListNode l2, ListNode result) {
        assertEquals(result, classUnderTest.addTwoNumbers(l1, l2));
    }

    static Stream<Arguments> inputsAndResultProvider() {
        return Stream.of(
                arguments(fromList(1, 8), fromList(0), fromList(1, 8)),
                arguments(fromList(), fromList(1), fromList(1)),
                arguments(fromList(), fromList(), fromList())
        );
    }

    // Get linkedList of ListNode
    static ListNode fromList(Integer... list) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int nodeValue : list) {
            curr.next = new ListNode(nodeValue);
            curr = curr.next;
        }
        return dummyHead.next;
    }

}