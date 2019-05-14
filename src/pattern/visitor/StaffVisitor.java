package pattern.visitor;

// File: StaffVisitor.java
abstract class StaffVisitor
{
   public abstract void visit (TeamLeader t);
   public abstract void visit (Clerk s);
}
