package members;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collections;

//@author: Tobias Vinther
public class WriteToFile {

    public void writeMembersToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("userfiles/member_list_printout.txt"));

            //would it make more sense to sort it every time a new member is added to MEMBER_LIST instead of here?
            Collections.sort(MemberList.getMemberArrayList());
            Collections.reverse(MemberList.getMemberArrayList());

            writer.write("DELFINEN MEDLEMSLISTE\n\n");

            for(Member member : MemberList.getMemberArrayList()) {
                writer.write(member.getName() + " | ");
                writer.write("ID: " + member.getMemberID() + " | ");
                writer.write(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(member.getBirthDay()) + " | ");
                writer.write(member.getAgeGroup() + " | ");
                writer.write(member.getMembershipType() + "t medlem" + " | ");
                if(!member.getActivityType().equals("")) {
                    writer.write(member.getActivityType() + " | ");
                }
                writer.write("\n--------------------------------------------------------\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("ERROR: Something went wrong when trying to write to file");
        }
    }

}
