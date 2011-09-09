package ricoko.arismorf;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывыающий структуру данных
 * 
 * @author maksimenkov (xupypr@xupypr.com) 
 */
public class DatabaseStructure {

    public static enum FieldType {

        VARCHAR, BIGINT, DOUBLE, DATE, BLOB
    }

    public static class Field {

        public String name;
        public FieldType type;

        public Field(String name, FieldType type) {
            this.name = name;
            this.type = type;
        }
    }
    public Map<String, List<Field>> structure;
    private static DatabaseStructure instance;

    private DatabaseStructure() {
    }

    public static DatabaseStructure getInstance() {
        if (instance == null) {
            instance = new DatabaseStructure();

            // Общая структура данных
            instance.structure = new HashMap<String, List<Field>>();

            // GRADES
            List<Field> GRADES = new ArrayList<Field>();
            GRADES.add(new Field("SYS_FLDORDER", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_GUID", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_STATE", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_REV", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_CREATED", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_UPDATED", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_CREATOR", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_GUIDFK", FieldType.VARCHAR));
            GRADES.add(new Field("SYS_PARENTGUID", FieldType.VARCHAR));
            GRADES.add(new Field("GRADEGROUPFK", FieldType.BIGINT));
            GRADES.add(new Field("LITER", FieldType.VARCHAR));
            GRADES.add(new Field("GRADENAME", FieldType.VARCHAR));
            GRADES.add(new Field("GRADEMARK", FieldType.VARCHAR));
            GRADES.add(new Field("CLASSREMARK", FieldType.BIGINT));
            GRADES.add(new Field("CLASSCOMPLETE", FieldType.BIGINT));
            GRADES.add(new Field("CLASSCOMPLETESET", FieldType.BIGINT));
            GRADES.add(new Field("CLASS_PROFILE", FieldType.BIGINT));
            GRADES.add(new Field("CLASS_PROFILE_UIOP", FieldType.BIGINT));
            GRADES.add(new Field("GRADEYMK", FieldType.BIGINT));
            GRADES.add(new Field("DIDACTICSYSTEM", FieldType.BIGINT));
            GRADES.add(new Field("GRADEBUP", FieldType.BIGINT));
            GRADES.add(new Field("PREPROFILETRAINING", FieldType.BIGINT));
            GRADES.add(new Field("PROFILETRAINING", FieldType.BIGINT));
            GRADES.add(new Field("PHYSCULT_THREEHOURS", FieldType.BIGINT));
            GRADES.add(new Field("CADETCLASS", FieldType.BIGINT));
            GRADES.add(new Field("VOCATIONALTRAINING", FieldType.BIGINT));
            GRADES.add(new Field("GRADERATEOPZ", FieldType.BIGINT));
            GRADES.add(new Field("GRADERATEOEZ", FieldType.BIGINT));
            GRADES.add(new Field("CLASSINITIAL_ENGLISH", FieldType.BIGINT));
            GRADES.add(new Field("CLASSINITIAL_GERMAN", FieldType.BIGINT));
            GRADES.add(new Field("CLASSINITIAL_FRENCH", FieldType.BIGINT));
            GRADES.add(new Field("TECHN_DEVELOPING", FieldType.BIGINT));
            GRADES.add(new Field("TECHN_INFORMATION", FieldType.BIGINT));
            GRADES.add(new Field("TECHN_HEALTH", FieldType.BIGINT));
            GRADES.add(new Field("RELIGIONNAME", FieldType.VARCHAR));
            GRADES.add(new Field("RELIGIONPROGRAMM", FieldType.VARCHAR));
            GRADES.add(new Field("RELIGIONFORM", FieldType.BIGINT));
            GRADES.add(new Field("RELIGIONMANUAL", FieldType.VARCHAR));
            GRADES.add(new Field("NATDIAS_LANGUANE", FieldType.BIGINT));
            GRADES.add(new Field("NATDIAS_FORM", FieldType.BIGINT));
            GRADES.add(new Field("NATDIAS_CHANGE", FieldType.VARCHAR));
            instance.structure.put("GRADES", GRADES);

            // ADDITIONALDATA
            List<Field> ADDITIONALDATA = new ArrayList<Field>();
            ADDITIONALDATA.add(new Field("SYS_FLDORDER", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_GUID", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_STATE", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_REV", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_CREATED", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_UPDATED", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_CREATOR", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_USER", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_GUIDFK", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("SYS_PARENTGUID", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("PLATFORM_SCHOOL", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLATFORM_MUNIC", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLATFORM_REPUB", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLAT_SCH_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLAT_SCH_THEME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("PLAT_MUN_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLAT_MUN_THEME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("PLAT_REP_THEME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("PLAT_SCH_PERIOD", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLAT_MUN_PERIOD", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLAT_REP_PERIOD", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PLAT_SCH_PRIKAZ", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("PLAT_MUN_PRIKAZ", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("PLAT_REP_PRIKAZ", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("INTERCOOPERATION_OY", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("INTERCOOPERATION_COUNTRY", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("INTERCOOPERATION_PROGRAMM", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("LEGALSTATUS_10", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("LEGALSTATUS_11", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("LEGALSTATUS_12", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("COUNCIL_BOARD", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("COUNCIL_OPERATING", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("COUNCIL_SCHOOL", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("COUNCIL_OTHER", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("ACTIONS_REPUB_LEVEL", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTIONS_COUNT_LEVEL", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTREPLEV_COMPETITION", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTREPLEV_CONFERENCE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTREPLEV_OTHER", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTRUSLEV_COMPETITION", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTRUSLEV_CONFERENCE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTRUSLEV_OTHER", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PUBLICREPORT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("REPUB_RESOURCE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("REPUB_RESOURCE_INFO", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("METHODICAL_CENTER", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("METHODICAL_CENTER_INFO", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("WINOLYM_MUN", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_REP", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_RUS", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_MUN1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_MUN2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_MUN3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_MUN", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_REP", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_RUS", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_REP1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_REP2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_REP3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_REP1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_REP2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_REP3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_RUS1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_RUS2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_RUS3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_RUS1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_RUS2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_RUS3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_MUN", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_REP", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_REP1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_REP2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_REP3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_RUS", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_RUS1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_RUS2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_RUS3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ROYKRMFLI_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ROYGIMART_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ROYKGPI_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ROYPMCYP_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("REWGRAD_GOLD_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("REWGRAD_SILVER_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("REWGRAD_DOCUM_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OYYKP_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OYPPEEGE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OYTEKNINE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OYPPENINE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("STUDYREPEATYEAR_14", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("STUDYREPEATYEAR_59", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("STUDYREPEATYEAR_1011", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("SCHOOLSPRAVKA", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("ACTREPLEV_COMPETITION_NAME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("ACTREPLEV_CONFERENCE_NAME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("ACTREPLEV_OTHER_NAME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("ACTRUSLEV_COMPETITION_NAME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("ACTRUSLEV_CONFERENCE_NAME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("ACTRUSLEV_OTHER_NAME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("WINCOMP_MUN1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_MUN2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_MUN3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_MUN1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_MUN2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_MUN3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_INT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_INT1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_INT2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINOLYM_INT3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_INT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_INT1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_INT2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCOMP_INT3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_INT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_INT1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_INT2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("WINCONT_INT3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTOLYM_SCH", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTOLYM_MUN", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTOLYM_REP", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTOLYM_RUS", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTOLYM_INT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCOMP_SCH", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCOMP_MUN", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCOMP_REP", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCOMP_RUS", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCOMP_INT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCONT_SCH", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCONT_MUN", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCONT_REP", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCONT_RUS", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PARTCONT_INT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PEOPLECHANGE1_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PEOPLECHANGE2_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PEOPLECHANGE3_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("PREPARCLASS_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIRE_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIRE_MATDAMAGE", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIREVICTIM", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIREVICEMP_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIREVICPEOP_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIREVICTIMDEATH", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIREVICDEATHEMP_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("FIREVICDEATHPEOP_CNT", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OMPLATFORM_MUNIC", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OMPLAT_MUN_THEME", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OMPLAT_MUN_PRIKAZ", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("OMPLATFORM_REPUB", FieldType.BIGINT));
            ADDITIONALDATA.add(new Field("OMPLAT_REP_THEME", FieldType.VARCHAR));
            ADDITIONALDATA.add(new Field("OMPLAT_REP_PRIKAZ", FieldType.VARCHAR));
            instance.structure.put("ADDITIONALDATA", ADDITIONALDATA);

            // SCHOOLS
            List<Field> SCHOOLS = new ArrayList<Field>();
            SCHOOLS.add(new Field("SYS_FLDORDER", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_GUID", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_STATE", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_REV", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_CREATED", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_UPDATED", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_CREATOR", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_USER", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_GUIDFK", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SYS_PARENTGUID", FieldType.VARCHAR));
            SCHOOLS.add(new Field("REGIONFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLID", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLNUM", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLNAME", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SHORTNAME", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SCHOOLTYPEFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLKINDFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLPROPERTYFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("GOVERNMENTFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("MINISTRYFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("AREAFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("UR_POSTINDEX", FieldType.VARCHAR));
            SCHOOLS.add(new Field("UR_ADDRESS", FieldType.VARCHAR));
            SCHOOLS.add(new Field("TOWNTYPEFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("NASPUNKT", FieldType.VARCHAR));
            SCHOOLS.add(new Field("FAKT_POSTINDEX", FieldType.VARCHAR));
            SCHOOLS.add(new Field("FAKT_ADDRESS", FieldType.VARCHAR));
            SCHOOLS.add(new Field("SCPOSITION", FieldType.VARCHAR));
            SCHOOLS.add(new Field("FIO", FieldType.VARCHAR));
            SCHOOLS.add(new Field("PHONES", FieldType.VARCHAR));
            SCHOOLS.add(new Field("FAXS", FieldType.VARCHAR));
            SCHOOLS.add(new Field("MAILS", FieldType.VARCHAR));
            SCHOOLS.add(new Field("ALLPEOPLE", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE11", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE10", FieldType.BIGINT));
            SCHOOLS.add(new Field("FIOSP", FieldType.VARCHAR));
            SCHOOLS.add(new Field("MAILSP", FieldType.VARCHAR));
            SCHOOLS.add(new Field("PHONESP", FieldType.VARCHAR));
            SCHOOLS.add(new Field("URL", FieldType.VARCHAR));
            SCHOOLS.add(new Field("DELETEDATE", FieldType.VARCHAR));
            SCHOOLS.add(new Field("DELETEREASON", FieldType.VARCHAR));
            SCHOOLS.add(new Field("STATIONCODE", FieldType.BIGINT));
            SCHOOLS.add(new Field("PCENTERFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLYIOP", FieldType.BIGINT));
            SCHOOLS.add(new Field("WINPNPO", FieldType.BIGINT));
            SCHOOLS.add(new Field("HASVIDEO", FieldType.BIGINT));
            SCHOOLS.add(new Field("LOTCOMPLECT_OY", FieldType.BIGINT));
            SCHOOLS.add(new Field("TOP100", FieldType.BIGINT));
            SCHOOLS.add(new Field("ISFILIAL", FieldType.BIGINT));
            SCHOOLS.add(new Field("PARENTFK", FieldType.BIGINT));
            SCHOOLS.add(new Field("GOSREGNUM", FieldType.VARCHAR));
            SCHOOLS.add(new Field("INN", FieldType.VARCHAR));
            SCHOOLS.add(new Field("ISCHECKED", FieldType.BIGINT));
            SCHOOLS.add(new Field("ALLPEOPLE_14", FieldType.BIGINT));
            SCHOOLS.add(new Field("ALLPEOPLE_59", FieldType.BIGINT));
            SCHOOLS.add(new Field("ALLPEOPLE_1011", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE11_9", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE11_11", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE10_8", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE10_10", FieldType.BIGINT));
            SCHOOLS.add(new Field("PEOPLE11_12", FieldType.BIGINT));
            SCHOOLS.add(new Field("SCHOOLPROGRAMDOY", FieldType.BIGINT));
            SCHOOLS.add(new Field("S_PM", FieldType.BIGINT));
            SCHOOLS.add(new Field("TOP100_PRIKAZ", FieldType.VARCHAR));
            SCHOOLS.add(new Field("CODE_OKPO", FieldType.BIGINT));
            instance.structure.put("SCHOOLS", SCHOOLS);
            
            // PARTICIPANTS
            List<Field> PARTICIPANTS = new ArrayList<Field>();
            PARTICIPANTS.add(new Field("SYS_FLDORDER", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_GUID", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_STATE", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_REV", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_CREATED", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_UPDATED", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_CREATOR", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_USER", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_GUIDFK", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SYS_PARENTGUID", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("IDENTIFIER", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SURNAME", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("NAME", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SECONDNAME", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("DOCUMENTTYPEFK", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("DOCUMENTSERIES", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("DOCUMENTNUMBER", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("SEX", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("BIRTHDAY", FieldType.VARCHAR));// TODO: проверить, возможна некорректность дат
            PARTICIPANTS.add(new Field("EXPINFO", FieldType.VARCHAR));
            PARTICIPANTS.add(new Field("D_LIMITEDPOTENTFK", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("PAID_EDUC_SERVICES", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("STUDESELFMANAG", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("PUBLICASSOCIATION", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("BEGDATE", FieldType.VARCHAR));// TODO: проверить, возможна некорректность дат
            PARTICIPANTS.add(new Field("LIMITEDHEALTH", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("TRANSFER_CONDITIONALLY", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("EXTERNSHIP", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("FORMATIONFAMILY", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("INDIVIDSTUDY", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("TRANSFERCLASS", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("PEOPLELEAVING_DATA", FieldType.VARCHAR)); // TODO: проверить, возможна некорректность дат
            PARTICIPANTS.add(new Field("PEOPLELEAVING", FieldType.BIGINT));
            PARTICIPANTS.add(new Field("PEOPLEAFRER1SEP", FieldType.BIGINT));
            instance.structure.put("PARTICIPANTS", PARTICIPANTS);
        }
        return instance;
    }

    public String getCreateScript(String tableName) {
        StringBuilder result = new StringBuilder();
        result.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" ("); 
        boolean first = true;
        for (Field f : structure.get(tableName)) {
            result.append((first)?"":",").append(f.name).append(" ").append((f.type.equals(FieldType.VARCHAR))?"VARCHAR(255)":f.type);            
            result.append(("SYS_GUID".equals(f.name))?" PRIMARY KEY":"");
            first = false;
        }
        result.append(");");
        return result.toString();
    }
    
    public String getInsertScript(String tableName, Map<String, String> values) {
        StringBuilder result = new StringBuilder();
        result.append("REPLACE INTO ").append(tableName).append(" (");
        boolean first = true;
        for (Field f : structure.get(tableName)) {
            result.append((first)?"":",").append(f.name);
            first = false;
        }
        first = true;
        result.append(" ) VALUES (");
        for (Field f : structure.get(tableName)) {
            if (f.type.equals(FieldType.DATE) || f.type.equals(FieldType.VARCHAR)) {
                result.append((first)?"":",").append("'").append(values.get(f.name)).append("'");
            } else {
                result.append((first)?"":",").append((values.get(f.name)==null || values.get(f.name).equals(""))?"NULL":values.get(f.name));
            }
            first = false;
        }
        result.append(");");
        return result.toString();
    }

    public void createAllTables(Connection connection) throws SQLException {
        for (String tableName:structure.keySet()) {
            Statement statement = connection.createStatement();
            statement.execute(getCreateScript(tableName));
            statement.close();        
        }
    }
}
