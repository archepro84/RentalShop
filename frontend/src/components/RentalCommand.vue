<template>

    <v-card outlined>
        <v-card-title>
            Rental
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <Number label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
            <Number label="RentalShopId" v-model="value.rentalShopId" :editMode="editMode"/>
            <Number label="StockId" v-model="value.stockId" :editMode="editMode"/>
            <String label="RentalStatus" v-model="value.rentalStatus" :editMode="editMode"/>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
            <Date label="StartedAt" v-model="value.startedAt" :editMode="editMode"/>
            <Date label="EndedAt" v-model="value.endedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="rental"
            >
                Rental
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RentalCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.customerId = 0;
            this.value.rentalShopId = 0;
            this.value.stockId = 0;
            this.value.rentalStatus = '';
            this.value.qty = 0;
            this.value.startedAt = '2023-06-09';
            this.value.endedAt = '2023-06-09';
        },
        watch: {
        },
        methods: {
            rental() {
                this.$emit('rental', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

