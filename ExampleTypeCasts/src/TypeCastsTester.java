
public class TypeCastsTester {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		C oc = new E();
		/* Static type of oc: C; Dynamic type of oc: E */

		/* Compilable Casts: Upward or Downward from the ST of oc */
		A oa = (A) oc; // No ClassCastException at runtime: DT E is a descendant of cast type A.
		E oe = (E) oc; // No ClassCastException at runtime: DT E is a descendant of cast type E.
		F of = (F) oc; // ClassCastException at runtime: DT E is NOT a descendant of cast type F.
		D od = (D) oc; // ClassCastException at runtime: DT E is NOT a descendant of cast type D.
		
		/* Non-compilable Casts: 
		 * Cast type (B) is neither an anecestor nor a descendant
		 * of the static type of oc (C).  
		 */
//		B ob = (B) oc;
	}
}
