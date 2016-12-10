package com.example.recyclopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alpha on 12/10/2016.
 */
public class ExpandedListActivity extends Activity {

        ExpandableListView explistView;
        HashMap<String,List<String>> listHashMap = new HashMap<String, List<String>>();
        EncyclopediaAdapter explistAdapter;
        RecyclopediaDBHelper dbHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.exp_main);
            Button backButton = (Button) findViewById(R.id.Backbutt);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            });

            dbHelper = new RecyclopediaDBHelper(this);
            populateData();
            explistView = (ExpandableListView) findViewById(R.id.exp_list);
            //System.out.print("yeah " + dbHelper.getAllTopics());
            explistAdapter = new EncyclopediaAdapter(this, dbHelper.getHashMapTopics(), dbHelper.getListSubjects());

            explistView.setAdapter(explistAdapter);

            explistView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    final String selected = (String) explistAdapter.getChild(
                            groupPosition, childPosition);

                    Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                            .show();
                    Intent in = new Intent(getApplicationContext(),DetailsActivity.class);
                    in.putExtra("listPos", groupPosition);
                    in.putExtra("childPos", childPosition);
                    in.putExtra("notes", dbHelper.getDetails(selected));
                    startActivity(in);

                    return true;
                }
            });


        }

        public void populateData() {
            dbHelper.addTopic("Overview", "This law aims for the reduction of solid waste through source reduction and waste minimization measures, treatment and disposal of solid waste in accordance with ecologically sustainable development principles. (Sec. 2-C)\n" +
                    "It also aims to ensure the proper segregation, collection, transport, storage, treatment and disposal of solid waste through the formulation and adoption of the best environmental practice in ecological waste management excluding incineration.\n" +
                    "It considers “waste as a resource that can be recovered”, emphasizing on recycling, reuse and composting as methods to minimize waste problems.\n", "Ecological Solid Waste Management Act of 2000 (RA 9003)");
            dbHelper.addTopic("Three r''s", "•Reduce\n•Recover\n•Recycle\n","Ecological Solid Waste Management Act of 2000 (RA 9003)");
            dbHelper.addTopic("Waste Characterization and Segregation ","The Act provided a special account in the National Treasury called the Solid" +
                    " Waste Management Fund.  This will be sourced from fines and penalties imposed, " +
                    "proceeds of permits and licenses, donations, endowments, grants and contributions" +
                    " and amount allocated under the annual General Appropriations Act. The Fund will be utilized " +
                    "to finance products, facilities, technologies, and processes that would enhance proper solid waste" +
                    " management; awards and incentives; research programs; information, education, communication and monitoring " +
                    "activities; technical assistance; and capability building activities.", "Ecological Solid Waste Management Act of 2000 (RA 9003)" );
            dbHelper.addTopic("Types of Waste According to Source", "•\tResidual – waste with no commercial value meant for disposal\n" +
                    "•\tRecyclable - waste that can be reused\n" +
                    "•\t Biodegradable – waste that can be decomposed by organisms\n" +
                    "•\tHazardous – waste that may cause or contribute to mortality or illness\n" +
                    "•\t Toxic – waste that may cause immediate death or body damage.\n", "Ecological Solid Waste Management Act of 2000 (RA 9003)");
            dbHelper.addTopic("Provisions of RA 9003", "The said act gives strong emphasis on the role of municipal and local government units (LGUs) providing for the creation of Solid Waste Management Communities up to the barangay level. " +
                    "This requires the participation of nongovernment offices, people’s organizations, church leaders, schools, businesses and community organizations.","Ecological Solid Waste Management Act of 2000 (RA 9003)");

            dbHelper.addTopic("Penal Provisions","Chapter 6 provides a comprehensive list of prohibited acts including: (1) littering, throwing, dumping of waste matters in public places; (2) undertaking activities in violation of sanitation operation; (3) open burning of solid waste; (4) causing non-segregated waste; (5) squatting in open dumps and landfills; (6) open dumping, burying of biodegradable materials in flood-prone areas; (7) unauthorized removal of recyclable material; (8) mixing of source-separated recyclable material with other solid waste; (9) establishment or operation of open-dumps; (10) manufacturing, distributing, using, and importing consumer products that are non-environmentally-friendly materials; (11)  importing toxic wastes misrepresented as “recyclable” or “with recyclable content”; (12) transporting and dumping in bulk in areas other than facility centers; (13) site preparation, construction, expansion or operation of waste management facilities without an Environmental Compliance Certificate and not conforming with the land use plan of LGUs; (14) construction of establishment" +
                    " within 200 meters from dump sites or sanitary landfills; and (15) operation of waste disposal facility on any aquifer," +
                    " groundwater reservoir or watershed area.  ","Ecological Solid Waste Management Act of 2000 (RA 9003)" );
            dbHelper.addTopic("Financing Solid Waste Management","The Act provided a special account in the National Treasury called the Solid Waste Management Fund.  This will be sourced from fines and penalties imposed, proceeds of permits and licenses, donations, endowments, grants and contributions and amount allocated under the annual General Appropriations Act. The Fund will be utilized to finance products, facilities, technologies, and processes that would enhance proper solid waste management; awards and incentives; research programs; " +
                    "information, education, communication and monitoring activities; technical assistance; and capability building activities.","Ecological Solid Waste Management Act of 2000 (RA 9003)" );
            dbHelper.addTopic("Landfill","The Landfill is the most popularly used method of waste disposal used today. This process of waste disposal focuses attention on burying the waste in the land. Landfills are found in all areas. There is a process used that eliminates the odors and dangers of waste before it is placed into the ground. While it is true this is the most popular form of waste disposal it is certainly far from the only" +
                    " procedure and one that may also bring with it an assortment of space.","Methods of Waste Disposal" );
            dbHelper.addTopic("Incineration/Combustion ","Incineration or combustion is a type disposal method in which municipal solid wastes are burned at high temperatures so as as to convert them into residue and gaseous products. The biggest advantage of this type of method is that it can reduce the volume of solid waste to 20 to 30 percent of the original volume, decreases the space they take up and reduce the stress on landfills.","Methods of Waste Disposal" );
            dbHelper.addTopic("Recovery and Recycling ","Resource recovery is the process of taking useful discarded items for a specific next use. These discarded items are then processed to extract or recover materials and resources or convert them to energy in the form of useable heat, electricity or fuel.","Methods of Waste Disposal" );
            dbHelper.addTopic("Republic Act 7160 (Local Government Code)","• Effective 1991\n" +
                    "• Mandates local government units to exercise powers, functions and responsibilities in providing basic services and facilities " +
                    "related to general hygiene, sanitation, beautification and solid waste collection, transport and disposal.\n","Examples of Philippine Environmental Laws" );
            dbHelper.addTopic("Presidential Decree 825", "• Effective November 7, 1975\n" +
                    "• Penalizes improper disposal of garbage and other forms of being dirty. Violators may be imprisoned " +
                    "for not less than five days or more than a year or pay a fine or not less that P100 or more than P2,000 or both.\n","Examples of Philippine Environmental Laws");
            dbHelper.addTopic("Anti-Dumping Law", "• Effective September 5, 1938\n" +
                    "• Prohibits the dumping into rivers of refuse waste matter or substance of any kind.\n" +
                    "• Punishment of imprisonment of not more than six months or by a fine of not more than P200 or both.\n","Examples of Philippine Environmental Laws");
            dbHelper.addTopic("Republic Act 6969", "• Effective 1990\n" +
                    "• Mandates the control and management of the import, manufacture, processing, " +
                    "distribution, use, transport, treatment and disposal of toxic substances and hazardous and nuclear wastes " +
                    "in the country.\n","Examples of Philippine Environmental Laws" );
            dbHelper.addTopic("Examples of Biodegradable materials","Examples of Biodegradable materials, often referred to as “bio-waste”, include the following:\n" +
                    "\n" +
                    "• Human and animal waste\n" +
                    "• Plant products, wood, paper, food waste, leaves, grass clippings\n" +
                    "• Remains from the death of living creatures\n" +
                    "\n" +
                    "It is very important to note that biodegradable waste can serve to support the future life of other organisms. This waste can be used to provide nourishment and a healthy environment condition for living organisms, which of course includes humans.\n" +
                    "http://sprecycling.com/biodegradable-and-non-biodegradable-materials/\n", "Biodegradable Wastes");
            dbHelper.addTopic("Examples of Non-Biodegradable Wastes", "Materials having properties that do not breakdown or decay are called Non-biodegradable.\n" +
                    "\n" +
                    "Examples include:\n" +
                    "• Glass\n" +
                    "• Metals\n" +
                    "• Plastics\n" +
                    "• Electronic devices\n" +
                    "• Medical waste\n" +
                    "\n" +
                    "Non-biodegradable materials do not breakdown naturally. But, that doesn’t mean they cannot be reused. The key difference here is that the process requires time, energy and expense. Glass and plastic can be reused to make other products, but the waste must first be separated by type of material and then processed into a usable substance.\n" +
                    "http://sprecycling.com/biodegradable-and-non-biodegradable-materials/\n","Non Biodegradable Wastes");


        }
    }

