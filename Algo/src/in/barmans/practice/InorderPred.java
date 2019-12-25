package in.barmans.practice;

public class InorderPred {

	static class Result {
		public Result(boolean b, BNode pred2) {

			found = b;
			pred = pred2;
		}

		boolean found;
		BNode pred;
	}

	public static void main(String[] args) {
		BNode root = new BNode(7, new BNode(3, new BNode(1), new BNode(2)), new BNode(6, new BNode(4), new BNode(5)));
		BNode.printPost(root);
		System.out.println();

		Result res = postPred(root, 2, null);

		System.out.println(res.pred.data);
	}

	private static Result inorderPred(BNode node, int val, BNode pred) {
		if (node != null) {

			Result lResult = inorderPred(node.left, val, pred);
			if (lResult != null && lResult.found) {
				return lResult;
			}

			if (node.data == val) {
				return new Result(true, lResult != null ? lResult.pred : pred);
			}

			Result rResult = inorderPred(node.right, val, node);
			if (rResult != null && rResult.found) {
				return rResult;
			}
			// BNode pred =
			return new Result(false, node.right == null ? node : node.right);

		}

		return null;
	}

	private static Result inorderPost(BNode node, int val, BNode post) {
		if (node != null) {

			Result rResult = inorderPost(node.right, val, post);
			if (rResult != null && rResult.found) {
				return rResult;
			}

			if (node.data == val) {
				return new Result(true, rResult != null ? rResult.pred : post);
			}

			Result lResult = inorderPost(node.left, val, node);
			if (lResult != null && lResult.found) {
				return lResult;
			}
			// BNode pred =
			return new Result(false, node.left == null ? node : node.left);

		}

		return null;
	}

	private static Result postPred(BNode node, int val, BNode pred) {
		if (node == null) {
			return null;
		}

		Result resL = postPred(node.left, val, pred);
		if (resL != null && resL.found) {
			return resL;
		}

		Result resR = postPred(node.right, val, node.left == null ? pred : node.left);
		if (resR != null && resR.found) {
			return resR;
		}

		Result res;
		if (val == node.data) {
			res = new Result(true, node.right == null ? (node.left == null ? pred : node.left) : node.right);
			return res;
		}

		res = new Result(false, node);
		return res;

	}

	private static void connectSib(Node node, BNode parent) {
		
		

	}
}
